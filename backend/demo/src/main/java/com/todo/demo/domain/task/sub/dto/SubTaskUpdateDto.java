package com.todo.demo.domain.task.sub.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubTaskUpdateDto {
    private Long subTaskId;

    private String subTaskStatus;

    private String subTaskContent;

    private Long mainTaskId;
}
