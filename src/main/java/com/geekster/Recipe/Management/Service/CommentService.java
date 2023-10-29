package com.geekster.Recipe.Management.Service;

import com.geekster.Recipe.Management.Model.Comment;
import com.geekster.Recipe.Management.Model.Dto.AddCommentDto;
import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.Recipe;
import com.geekster.Recipe.Management.Repo.CommentRepo;
import com.geekster.Recipe.Management.Repo.RecipeRepo;
import jakarta.validation.constraints.Digits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    RecipeRepo recipeRepo;

    public String addComment(AddCommentDto addCommentDto) {
        AuthenticationInputDto authInfo=addCommentDto.getAuthInfo();
        if (tokenService.authenticate(authInfo)){
            commentRepo.save(addCommentDto.getComment());
            return "Comment added";
        }
        else{
            return "Sign-in please!!! ";
        }
    }

    public List<Comment> getCommentByRecipe(Integer recipeId) {
        if (recipeRepo.existsById(Long.valueOf(recipeId))){
            Recipe recipe= recipeRepo.findByRecipeId(Long.valueOf(recipeId));
            return commentRepo.findAllByRecipe(recipe);
        }
        else {
            return null;
        }
    }
}
