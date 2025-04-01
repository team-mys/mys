package com.todo.demo.security.filter;

import com.todo.demo.common.ResponseWrapper;
import com.todo.demo.common.code.ErrorCode;
import com.todo.demo.common.code.ErrorResponse;
import com.todo.demo.security.UserDetailsImpl;
import com.todo.demo.security.UserDetailsServiceImpl;
import com.todo.demo.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final ResponseWrapper responseWrapper;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtUtil.getJwtToken(request);
        try {
            if (token != null) {
                // 토큰 유효성 검증
                if(!jwtUtil.validToken(token)){
                    ErrorResponse errorResponse = new ErrorResponse(ErrorCode.TOKEN_EXPIRED_ERROR);
                    responseWrapper.convertObjectToResponse(response, errorResponse);
                    return;
                }

                Claims claims = jwtUtil.getClaims(token);
                setAuthentication(claims.getSubject());
            }
            filterChain.doFilter(request, response);
        }

        catch (Exception e){
            System.out.println("작동" + e.getMessage());
            ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
            responseWrapper.convertObjectToResponse(response, errorResponse);
        }
    }
    private void setAuthentication(String userId){
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(userId);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
