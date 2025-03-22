package com.todo.demo.domain.user.controller;

import com.todo.demo.domain.user.dto.UserRequestDto;
import com.todo.demo.domain.user.dto.UserResponseDto;
import com.todo.demo.domain.user.service.UserService;
import com.todo.demo.security.UserLoginDto;
import com.todo.demo.util.JwtToken;
import io.jsonwebtoken.Jwt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 관리 API")
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "사용자 회원가입", description = "userName, userPassword 기반으로 새로운 사용자를 생성합니다.")
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @Operation(summary = "사용자 로그인", description = "로그인에 성공하면 403 에러를 반환, 성공하면 AccessToken과 User 정보 반환")
    @PostMapping("/login")
    public JwtToken userLogin(@RequestBody UserLoginDto userLoginDto){
        return JwtToken.builder().accessToken(userLoginDto.getUserId()).build();
    }

}
