package com.todo.demo.domain.task.dto;

import com.todo.demo.domain.task.MainTask;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainTaskReqDto {
    private String mainTaskTitle;

    private String mainTaskContent;

    private Long userId;

    public MainTask asMainTask(){
        return MainTask.builder()
                .mainTaskTitle(mainTaskTitle)
                .mainTaskContent(mainTaskContent)
                .build();
    }
}
