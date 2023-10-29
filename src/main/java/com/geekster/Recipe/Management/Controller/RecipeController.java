package com.geekster.Recipe.Management.Controller;

import com.geekster.Recipe.Management.Model.Dto.AddRecipeDto;
import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.Recipe;
import com.geekster.Recipe.Management.Model.RecipeType;
import com.geekster.Recipe.Management.Model.User;
import com.geekster.Recipe.Management.Service.RecipeService;
import com.geekster.Recipe.Management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    UserService userService;

    @GetMapping("recipe")
    public List<Recipe> getAllRecipe(@Valid AuthenticationInputDto authinfo){
         return recipeService.getAllRecipe(authinfo);
    }

    @GetMapping("recipe/recipeType/{recipeType}")
    public List<Recipe> getRecipeByRecipeType(@Valid  AuthenticationInputDto authinfo, @PathVariable RecipeType recipeType){
        return recipeService.getRecipeByRecipeType(authinfo,recipeType);
    }

    @PostMapping("recipe")
    public String createRecipe(@Valid @RequestBody AddRecipeDto addRecipeDto){
        return recipeService.createRecipe(addRecipeDto);
    }

    @PutMapping("recipe/update")
    public String updateRecipe(@Valid @RequestBody AddRecipeDto addRecipeDto){
        return recipeService.updateRecipe(addRecipeDto);
    }

    @DeleteMapping("recipe/id/{recipeId}")
    public String deleteRecipeById(@PathVariable Integer recipeId,@Valid AuthenticationInputDto authInfo){
        return recipeService.deleteRecipeById(recipeId,authInfo);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
