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
    private String mainTaskStatus;
    private String mainTaskContent;
    private Long userId;

    private LocalDateTime createdAt;

    public static MainTaskResDto of(MainTask mainTask){
        return MainTaskResDto
                .builder()
                .mainTaskId(mainTask.getMainTaskId())
                .mainTaskContent(mainTask.getMainTaskContent())
                .mainTaskStatus(mainTask.parseStatus())
                .userId(mainTask.getUsers().getUserId())
                .createdAt(mainTask.getCreatedAt())
                .build();
    }

    public static List<MainTaskResDto> of(List<MainTask> mainTaskList){
        return mainTaskList.stream().map(MainTaskResDto::of).collect(Collectors.toList());
    }
}
