package com.todo.demo.security.filter;

import com.todo.demo.common.ResponseWrapper;
import com.todo.demo.common.code.ErrorCode;
import com.todo.demo.common.code.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomUnauthorizedHandler implements AuthenticationEntryPoint {
    private final ResponseWrapper responseWrapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        responseWrapper.convertObjectToResponse(response, new ErrorResponse(ErrorCode.USER_NOT_AUTHORIZED));
    }
}
