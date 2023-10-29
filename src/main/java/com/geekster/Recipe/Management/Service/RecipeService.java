package com.geekster.Recipe.Management.Service;

import com.geekster.Recipe.Management.Model.*;
import com.geekster.Recipe.Management.Model.Dto.AddRecipeDto;
import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Repo.IngredientRepo;
import com.geekster.Recipe.Management.Repo.RecipeRepo;
import com.geekster.Recipe.Management.Repo.StepRepo;
import com.geekster.Recipe.Management.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    IngredientRepo ingredientRepo;

    @Autowired
    StepRepo stepRepo;

    @Autowired
    UserRepo userRepo;
    public String createRecipe(AddRecipeDto addRecipeDto) {
        AuthenticationInputDto authInfo=addRecipeDto.getAuthInfo();
        if (tokenService.authenticate(authInfo)) {
            Recipe recipe=addRecipeDto.getRecipe();
            String userEmail=recipe.getUser().getUserEmail();
            if (userEmail==null){
                User user=new User();
                user.setUserEmail(userEmail);
            }
            List<Ingredient> ingredient=recipe.getIngredients();
            if (ingredient!=null){
                ingredientRepo.saveAll(ingredient);
            }
            List<Step> steps=recipe.getSteps();
            if (steps!=null){
                stepRepo.saveAll(steps);
            }
            recipeRepo.save(recipe);
            return "Recipe created!!!";
        }
        else{
            return null;
        }
    }

    public String updateRecipe(AddRecipeDto addRecipeDto) {
        AuthenticationInputDto authInfo = addRecipeDto.getAuthInfo();
        if (tokenService.authenticate(authInfo)) {
            Integer recipeId = addRecipeDto.getRecipe().getRecipeId();
            if (recipeRepo.existsById(Long.valueOf(recipeId))) {
                Recipe recipe = addRecipeDto.getRecipe();
                String userEmail=recipe.getUser().getUserEmail();
                if (userEmail.equals(authInfo.getEmail())){
                List<Ingredient> ingredient = recipe.getIngredients();
                if (ingredient != null) {
                    ingredientRepo.saveAll(ingredient);
                }
                List<Step> steps = recipe.getSteps();
                if (steps != null) {
                    stepRepo.saveAll(steps);
                }
                recipeRepo.save(recipe);
                return "Recipe updated";
                }
            } else {
                return "Invalid recipe-id!!!";
            }
        }
        else{
            return null;
        }

        return null;
    }
    public String deleteRecipeById(Integer recipeId,AuthenticationInputDto authInfo) {
        if (tokenService.authenticate(authInfo)) {
            Recipe recipe=recipeRepo.findByRecipeId(Long.valueOf(recipeId));
            if (recipe!=null&&recipe.getUser().getUserEmail().equals(authInfo.getEmail())) {
                recipeRepo.deleteById(Long.valueOf(recipeId));
                return "Recipe removed...";
            } else {
                return "Invalid credentials!!!";
            }
        }
        return null;
    }

    public List<Recipe> getAllRecipe(AuthenticationInputDto authinfo) {
        if (tokenService.authenticate(authinfo)){
            return recipeRepo.findAll();
        }
        else{
            return null;
        }
    }

    public List<Recipe> getRecipeByRecipeType(AuthenticationInputDto authinfo, RecipeType recipeType) {
        if (tokenService.authenticate(authinfo)){
            return recipeRepo.findByRecipeType(recipeType);
        }
        else{
            return null;
        }
    }
}
