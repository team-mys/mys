package com.todo.demo.domain.task.main.dto;

import com.todo.demo.domain.task.main.MainTask;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
