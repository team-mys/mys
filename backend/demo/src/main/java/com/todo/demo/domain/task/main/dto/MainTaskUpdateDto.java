package com.todo.demo.domain.task.main.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainTaskUpdateDto {
    private Long mainTaskId;

    private Long userId;

    private String mainTaskTitle;

    private String mainTaskContent;

}
