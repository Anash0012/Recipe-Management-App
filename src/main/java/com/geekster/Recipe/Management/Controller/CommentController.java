package com.geekster.Recipe.Management.Controller;

import com.geekster.Recipe.Management.Model.Comment;
import com.geekster.Recipe.Management.Model.Dto.AddCommentDto;
import com.geekster.Recipe.Management.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("add/comment")
    public String addComment(@Valid @RequestBody AddCommentDto addCommentDto){
        return commentService.addComment(addCommentDto);
    }

    @GetMapping("comment/recipeId/{recipeId}")
    public List<Comment> getCommentsByRecipe(@PathVariable Integer recipeId){
        return commentService.getCommentByRecipe(recipeId);
    }
}
