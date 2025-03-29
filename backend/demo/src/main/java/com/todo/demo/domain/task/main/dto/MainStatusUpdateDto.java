package com.todo.demo.domain.task.main.dto;

import com.todo.demo.domain.task.TaskStatus;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MainStatusUpdateDto {
    private Long mainTaskId;

    @Pattern(regexp = "^(시작전|진행중|완료)$", message = "mainTaskStatus는 '시작전', '진행중', '완료' 중 하나여야 합니다.")
    private String mainTaskStatus;

    public TaskStatus toEnum(){
        return TaskStatus.fromDescription(this.mainTaskStatus);
    }
}
