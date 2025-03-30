package com.todo.demo.domain.user.service;

import com.todo.demo.common.code.ErrorCode;
import com.todo.demo.common.exception.CustomException;
import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.dto.UserEditDto;
import com.todo.demo.domain.user.dto.UserRequestDto;
import com.todo.demo.domain.user.dto.UserResponseDto;
import com.todo.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userReq){
        if(isUserDuplicated(userReq.getUserName())){
            throw new CustomException(ErrorCode.USER_DUPLICATED_ERROR);
        }
        Users reqUser = userReq.asUser();
        reqUser.encodedUserPassword(passwordEncoder.encode(userReq.getUserPassword()));
        Users saveUser = userRepository.save(reqUser);
        return UserResponseDto.of(saveUser);
    }

    @Transactional
    public UserResponseDto updateUser(UserEditDto userEditDto){
        Users findUser = userRepository.findById(userEditDto.getUserId()).get();
        if(userEditDto.getUserPassword() == null){
            findUser.updateUserNickName(userEditDto.getUserNickName());
        }else{
            findUser.updateUserEditInfo(userEditDto.getUserNickName(), passwordEncoder.encode(userEditDto.getUserPassword()));
        }
        return UserResponseDto.of(findUser);
    }

    @Transactional(readOnly = true)
    public boolean isUserDuplicated(String userName){
        return userRepository.findUsersByUserName(userName).isPresent();
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUserList(){
        return UserResponseDto.of(userRepository.findAll());
    }

    @Transactional
    public void deleteUserByUserId(Long userId){
        userRepository.deleteById(userId);
    }
}
