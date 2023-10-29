package com.geekster.Recipe.Management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;
    private String ingredientName;
    private double quantity;
    private double price;
    @Enumerated(value = EnumType.STRING)
    private Category category;

}