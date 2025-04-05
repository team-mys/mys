package com.todo.demo.domain.task.main.dto;

import com.todo.demo.domain.task.main.MainTask;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class MainTaskResDto {
    private Long mainTaskId;
    private String mainTaskContent;
    private Long userId;
    private boolean isSuccess;
    private LocalDateTime createdAt;

    public static MainTaskResDto of(MainTask mainTask){
        return MainTaskResDto
                .builder()
                .mainTaskId(mainTask.getMainTaskId())
                .mainTaskContent(mainTask.getMainTaskContent())
                .userId(mainTask.getUsers().getUserId())
                .isSuccess(mainTask.getIsSuccess())
                .createdAt(mainTask.getCreatedAt())
                .build();
    }

    public static List<MainTaskResDto> of(List<MainTask> mainTaskList){
        return mainTaskList.stream().map(MainTaskResDto::of).collect(Collectors.toList());
    }
}
