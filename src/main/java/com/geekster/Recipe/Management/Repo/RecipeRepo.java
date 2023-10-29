package com.geekster.Recipe.Management.Repo;

import com.geekster.Recipe.Management.Model.Category;
import com.geekster.Recipe.Management.Model.Recipe;
import com.geekster.Recipe.Management.Model.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe,Long> {


    List<Recipe> findByRecipeType(RecipeType recipeType);

    Recipe findByRecipeId(Long recipeId);
}
