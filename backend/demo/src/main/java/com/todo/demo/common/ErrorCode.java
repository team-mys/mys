package com.todo.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "COMMON-001", "SERVER ERROR"),

    //권한이 없음
    FORBIDDEN_ERROR(403, "COMMON_002", "FOR BIDDEN"),
    NOTFOUND_ERROR(404, "COMMON_003", "NOT FOUND");
    private final int status;
    private final String divisionCode;
    private final String reason;


}
