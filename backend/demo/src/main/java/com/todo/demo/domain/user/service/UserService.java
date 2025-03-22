package com.todo.demo.domain.user.service;

import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.dto.UserRequestDto;
import com.todo.demo.domain.user.dto.UserResponseDto;
import com.todo.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto createUser(UserRequestDto userReq){
        Users reqUser = userReq.asUser();
        reqUser.encodedUserPassword(passwordEncoder.encode(userReq.getUserPassword()));
        Users saveUser = userRepository.save(reqUser);
        return UserResponseDto.of(saveUser);
    }
}
