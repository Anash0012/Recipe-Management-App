package com.geekster.Recipe.Management.Controller;

import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.Dto.StepAuthenticationDto;
import com.geekster.Recipe.Management.Model.Step;
import com.geekster.Recipe.Management.Service.StepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StepController {

    @Autowired
    private StepService stepService;

    @GetMapping("step/{recipeId}/{stepId}")
    public List<Step> getStepByRecipeId(@PathVariable Long recipeId, @PathVariable Long stepId, @Valid @RequestBody AuthenticationInputDto authInfo) {
       return stepService.getStepByRecipeId(recipeId,stepId,authInfo);
    }

    @PostMapping("create/steps/{recipeId}")
    public String createStep(@Valid @RequestBody StepAuthenticationDto stepAuthenticationDto, @PathVariable Long recipeId) {
        return stepService.createStep(stepAuthenticationDto,recipeId);
    }

    @PutMapping("step/{recipeId}")
    public String updateStep(@PathVariable Long recipeId, @RequestBody StepAuthenticationDto stepAuthenticationDto) {
        return stepService.updateStep(recipeId,stepAuthenticationDto);
    }

    @DeleteMapping("step/{stepId}/{recipeId}")
    public String deleteStep(@PathVariable Long recipeId, @PathVariable Long stepId,@Valid @RequestBody AuthenticationInputDto authInfo) {
        return stepService.deleteStep(recipeId,stepId,authInfo);
    }
}
