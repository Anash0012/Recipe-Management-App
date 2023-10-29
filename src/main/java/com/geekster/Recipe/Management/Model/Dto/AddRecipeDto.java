package com.geekster.Recipe.Management.Model.Dto;

import com.geekster.Recipe.Management.Model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRecipeDto {

    private Recipe recipe;
    private AuthenticationInputDto authInfo;
}
