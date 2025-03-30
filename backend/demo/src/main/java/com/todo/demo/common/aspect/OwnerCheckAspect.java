package com.todo.demo.common.aspect;

import com.todo.demo.common.service.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class OwnerCheckAspect {

    public void checkOwnerShip(JoinPoint joinPoint, OwnerCheck ownerCheck){
        Long currentUserId = SecurityUtil.getCurrentUserId();
    }
}
