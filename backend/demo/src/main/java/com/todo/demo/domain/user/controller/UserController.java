package com.todo.demo.domain.user.controller;

import com.todo.demo.domain.user.dto.UserEditDto;
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

import java.util.List;

@Tag(name = "유저 관리 API")
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "사용자 목록 불러오기", description = "회원가입한 모든 사용자 정보를 불러와서 UserResponseDto List를 반환합니다.")
    @GetMapping
    public List<UserResponseDto> getAllUserList(){
        return userService.getAllUserList();
    }

    @Operation(summary = "사용자 회원가입", description = "userName, userPassword 기반으로 새로운 사용자를 생성합니다.")
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

    @Operation(summary = "사용자 아이디 중복 확인", description = "userName이 이미 존재하면 true, 존재하지 않으면 false를 반환합니다.")
    @GetMapping("/{userName}")
    public Boolean checkUserNameDuplicated(@PathVariable String userName){
        return userService.isUserDuplicated(userName);
    }

    @Operation(summary = "사용자 회원정보 수정", description = "userId로 검색 -> userNickName, userPassword를 업데이트 합니다. userPassword를 입력하지 않으면 기존의 값으로 대체됩니다.")
    @PutMapping
    public UserResponseDto updateUser(@RequestBody UserEditDto userEditDto){
        return userService.updateUser(userEditDto);
    }

    @Operation(summary = "사용자 정보 삭제", description = "userId를 받아서 해당하는 Users 객체를 삭제합니다.")
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUserByUserId(userId);
    }

    @Operation(summary = "사용자 로그인", description = "로그인에 성공하면 403 에러를 반환, 성공하면 AccessToken과 User 정보 반환")
    @PostMapping("/login")
    public JwtToken userLogin(@RequestBody UserLoginDto userLoginDto){
        return JwtToken.builder().accessToken(userLoginDto.getUserId()).build();
    }

}
