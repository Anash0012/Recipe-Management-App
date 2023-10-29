package com.geekster.Recipe.Management.Repo;

import com.geekster.Recipe.Management.Model.Comment;
import com.geekster.Recipe.Management.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
    List<Comment> findAllByRecipe(Recipe recipe);
}
