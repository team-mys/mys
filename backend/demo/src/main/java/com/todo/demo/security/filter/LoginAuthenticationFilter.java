package com.todo.demo.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.demo.common.ResponseWrapper;
import com.todo.demo.common.code.ErrorCode;
import com.todo.demo.common.code.ErrorResponse;
import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.dto.UserResponseDto;
import com.todo.demo.domain.user.repository.UserRepository;
import com.todo.demo.security.UserDetailsImpl;
import com.todo.demo.security.UserLoginDto;
import com.todo.demo.util.JwtToken;
import com.todo.demo.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final JwtUtil jwtUtil;
    private final ResponseWrapper responseWrapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {

            System.out.println();
            UserLoginDto userLoginDto = new ObjectMapper().readValue(request.getInputStream(), UserLoginDto.class);

            log.error(userLoginDto.toString());

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDto.getUserName(),
                            userLoginDto.getUserPassword())
            );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String userId = userDetails.getUsername();

        String accessToken = jwtUtil.generateAccessToken(userId);
        Users users = userDetails.getUsers();

        JwtToken jwtToken = JwtToken.builder()
                .accessToken(accessToken)
                .userResponseDto(UserResponseDto.of(users))
                .build();

        responseWrapper.convertObjectToResponse(response, jwtToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.USER_NOT_FOUND_ERROR);
        responseWrapper.convertObjectToResponse(response, errorResponse);
    }

}
