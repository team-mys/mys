package com.todo.demo.common.exception;

import com.todo.demo.common.code.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getReason());
        this.errorCode = errorCode;
    }
}
