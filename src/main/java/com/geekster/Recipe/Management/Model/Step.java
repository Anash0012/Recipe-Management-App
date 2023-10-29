package com.geekster.Recipe.Management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Step {
    @Id
    private Long stepId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;
}
