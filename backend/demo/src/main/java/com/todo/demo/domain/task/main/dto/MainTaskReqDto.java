package com.todo.demo.domain.task.main.dto;

import com.todo.demo.domain.task.main.MainTask;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainTaskReqDto {
    private String mainTaskContent;
    private Long userId;

    public MainTask asMainTask(){
        return MainTask.builder()
                .mainTaskContent(mainTaskContent)
                .build();
    }
}
