package com.geekster.Recipe.Management.Model.Dto;

import com.geekster.Recipe.Management.Model.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepAuthenticationDto {
    private AuthenticationInputDto authInfo;
    private Step step;
}
