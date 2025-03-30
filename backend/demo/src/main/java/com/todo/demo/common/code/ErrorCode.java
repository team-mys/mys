package com.todo.demo.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "COMMON-001", "SERVER ERROR"),
    USER_DUPLICATED_ERROR(400, "USER_001", "이미 존재하는 사용자입니다."),
    //권한이 없음
    FORBIDDEN_ERROR(403, "COMMON_002", "FOR BIDDEN"),
    NOTFOUND_ERROR(404, "COMMON_003", "NOT FOUND");
    private final int status;
    private final String divisionCode;
    private final String reason;


}
