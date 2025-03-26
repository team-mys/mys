package com.todo.demo.domain.user.dto;

import com.todo.demo.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserEditDto {

    private Long userId;
    private String userPassword;
    private String userNickName;

}
