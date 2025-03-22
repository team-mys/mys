package com.todo.demo.domain.user.dto;

import com.todo.demo.domain.user.Users;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponseDto {
    private Long userId;
    private String userName;
    private String userPassword;

    public static UserResponseDto of(Users users){
        return UserResponseDto.builder()
                .userId(users.getUserId())
                .userName(users.getUserName())
                .userPassword(users.getUserPassword())
                .build();
    }
}
