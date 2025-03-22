package com.todo.demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.dto.UserResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtToken {
    private String accessToken;
    private UserResponseDto userResponseDto;
}
