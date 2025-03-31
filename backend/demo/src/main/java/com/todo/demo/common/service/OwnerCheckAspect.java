package com.todo.demo.common.service;

import com.todo.demo.common.annotation.OwnerCheck;
import com.todo.demo.common.service.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class OwnerCheckAspect {

    private final OwnerValidationService ownerValidationService;

    @Before("@annotation(ownerCheck)")
    public void checkOwnerShip(JoinPoint joinPoint, OwnerCheck ownerCheck){
        Long currentUserId = SecurityUtil.getCurrentUserId();

        // 현재 로그인 한 사용자 ID 가져오기
        String paramName = ownerCheck.resourceIdParam();
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = methodSignature.getParameterNames();

    }
}
