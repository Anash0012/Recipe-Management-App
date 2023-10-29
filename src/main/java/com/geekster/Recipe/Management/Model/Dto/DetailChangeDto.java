package com.geekster.Recipe.Management.Model.Dto;

import com.geekster.Recipe.Management.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailChangeDto {
    private AuthenticationInputDto authInfo;
    private User user;
}
