package com.geekster.Recipe.Management.Model.Dto;

import com.geekster.Recipe.Management.Model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentDto {
    private AuthenticationInputDto authInfo;
    private Comment comment;
}
