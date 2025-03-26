package com.todo.demo.domain.task.sub.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubTaskUpdateDto {
    private String subTaskTitle;

    private String mainTaskContent;

    private Long userId;
}
