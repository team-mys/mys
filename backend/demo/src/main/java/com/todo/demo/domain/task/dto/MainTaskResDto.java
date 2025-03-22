package com.todo.demo.domain.task.dto;

import com.todo.demo.domain.task.MainTask;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainTaskResDto {
    private Long mainTaskId;

    private String mainTaskTitle;

    private String mainTaskContent;

    private Long userId;

    public static MainTaskResDto of(MainTask mainTask){
        return MainTaskResDto
                .builder()
                .mainTaskId(mainTask.getMainTaskId())
                .mainTaskTitle(mainTask.getMainTaskTitle())
                .mainTaskContent(mainTask.getMainTaskContent())
                .userId(mainTask.getUsers().getUserId())
                .build();
    }
}
