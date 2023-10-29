package com.geekster.Recipe.Management.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Recipe.class,property="recipeId")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipeId;
    private String recipeName;
    private String recipeInstructions;
    private Integer recipeCookingTime;
    private Integer recipeServings;
    private String recipeAuthor;
    @Enumerated(value = EnumType.STRING)
    private RecipeType recipeType;
    @ManyToMany
    @JoinTable(name = "recipe_ingredient")
    private List<Ingredient> ingredients;
    @OneToMany(mappedBy = "recipe")
    private List<Step> steps;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
