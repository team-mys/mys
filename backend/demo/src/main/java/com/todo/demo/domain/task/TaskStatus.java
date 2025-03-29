package com.todo.demo.domain.task;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TaskStatus {
    PENDING("시작전"),
    IN_PROGRESS("진행중"),
    COMPLETED("완료");
    private final String statusDescription;

    TaskStatus(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public static TaskStatus fromDescription(String description) {
        return Arrays.stream(TaskStatus.values())
                .filter(e -> e.getStatusDescription().equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 상태: " + description));
    }
}
