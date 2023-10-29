package com.geekster.Recipe.Management.Repo;

import com.geekster.Recipe.Management.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient,Ingredient> {
}
