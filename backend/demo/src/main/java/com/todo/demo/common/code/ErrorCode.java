package com.todo.demo.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "COMMON_001", "SERVER ERROR"),
    USER_DUPLICATED_ERROR(400, "USER_001", "이미 존재하는 사용자입니다."),
    USER_NOT_FOUND_ERROR(404, "USER_OO2", "사용자를 찾을 수 없습니다."),
    USER_NOT_AUTHORIZED(403, "AUTH_001", "사용 권한이 존재하지 않습니다."),
    TOKEN_EXPIRED_ERROR(403, "COMMON_002", "토큰 사용 기간이 만료되었습니다."),
    //권한이 없음
    FORBIDDEN_ERROR(403, "COMMON_002", "FOR BIDDEN"),
    NOTFOUND_ERROR(404, "COMMON_003", "NOT FOUND");
    private final int status;
    private final String divisionCode;
    private final String reason;


}
