package com.todo.demo.domain.user.dto;

import com.todo.demo.domain.user.Users;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponseDto {
    private Long userId;
    private String userName;
    private String userNickName;
    private String userPassword;

    public static UserResponseDto of(Users users){
        return UserResponseDto.builder()
                .userId(users.getUserId())
                .userName(users.getUserName())
                .userNickName(users.getUserNickName())
                .userPassword(users.getUserPassword())
                .build();
    }

    public static List<UserResponseDto> of(List<Users> userList){
        return userList.stream().map(UserResponseDto::of).collect(Collectors.toList());
    }
}
