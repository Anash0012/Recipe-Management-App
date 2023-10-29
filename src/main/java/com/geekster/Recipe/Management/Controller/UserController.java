package com.geekster.Recipe.Management.Controller;

import com.geekster.Recipe.Management.Model.Category;
import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.Dto.DetailChangeDto;
import com.geekster.Recipe.Management.Model.Dto.SignInInputDto;
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
public class UserController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    UserService userService;

    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User user){
        return userService.userSignUp(user);
    }
    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }
    @DeleteMapping("user/signout")
    public String userSignOut(@RequestBody AuthenticationInputDto authinfo){
        return userService.userSignOut(authinfo);
    }
    @PutMapping("user/change/details")
    public String changeUserDeatils(@Valid @RequestBody DetailChangeDto detailChangeDto){
        return  userService.changeUserDeatils(detailChangeDto);
    }

}
