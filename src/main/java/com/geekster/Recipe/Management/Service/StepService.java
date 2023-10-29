package com.geekster.Recipe.Management.Service;

import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.Dto.StepAuthenticationDto;
import com.geekster.Recipe.Management.Model.Recipe;
import com.geekster.Recipe.Management.Model.Step;
import com.geekster.Recipe.Management.Repo.RecipeRepo;
import com.geekster.Recipe.Management.Repo.StepRepo;
import com.geekster.Recipe.Management.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepService {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    StepRepo stepRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TokenService tokenService;
    public String createStep(StepAuthenticationDto stepAuthenticationDto,Long recipeId) {
        AuthenticationInputDto authinfo=stepAuthenticationDto.getAuthInfo();
        if (tokenService.authenticate(authinfo)) {
              Recipe recipe=recipeRepo.findByRecipeId(recipeId);
            if ( recipe!= null) {
                Step step=stepAuthenticationDto.getStep();
                step.setRecipe(recipe);
                stepRepo.save(step);
                return "Steps added to recipe...";
            }
            return null;
        }
        else{
            return "Invalid Credientials!!!";
        }
    }

    public List<Step> getStepByRecipeId(Long recipeId, Long stepId, AuthenticationInputDto authInfo) {
        if (tokenService.authenticate(authInfo)){
            Recipe recipe=recipeRepo.findByRecipeId(recipeId);
            return (List<Step>) stepRepo.findByStepId(stepId);
        }
        else{
            return null;
        }
    }

    public String updateStep(Long recipeId, StepAuthenticationDto stepAuthenticationDto) {
        AuthenticationInputDto authInfo=stepAuthenticationDto.getAuthInfo();
        if (tokenService.authenticate(authInfo)){
            Recipe recipe=recipeRepo.findByRecipeId(recipeId);
            if ( recipe!= null&&recipe.getUser().getUserEmail().equals(authInfo.getEmail())) {
                Step step=stepAuthenticationDto.getStep();
                step.setRecipe(recipe);
                stepRepo.save(step);
                return "Steps updated to recipe...";
            }
            return null;
        }
        else{
            return null;
        }
    }

    public String deleteStep(Long recipeId, Long stepId, AuthenticationInputDto authInfo) {
        if (tokenService.authenticate(authInfo)){
            Step step=stepRepo.findByStepId(stepId);
            Recipe recipe=recipeRepo.findByRecipeId(Long.valueOf(step.getRecipe().getRecipeId()));
            if (step!=null&&recipe.getUser().getUserEmail().equals(authInfo.getEmail())){
                stepRepo.deleteById(stepId);
                return "Steps deleted...";
            }
            else{
                return "step not found";
            }
        }
        else {
            return  null;
        }
    }
}
