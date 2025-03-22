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
public class UserRequestDto {
    private String userName;
    private String userPassword;

    public Users asUser(){
        return Users.builder()
                .userName(userName)
                .userPassword(userPassword)
                .build();
    }
}
