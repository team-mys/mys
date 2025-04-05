package com.todo.demo.domain.task.sub.dto;

import com.todo.demo.domain.task.sub.SubTask;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class SubTaskResDto {
    private Long subTaskId;

    private String subTaskContent;

    private boolean isSuccess;

    private long mainTaskId;

    public static SubTaskResDto of(SubTask subTask){
        return SubTaskResDto.builder()
                .subTaskId(subTask.getSubTaskId())
                .subTaskContent(subTask.getSubTaskContent())
                .mainTaskId(subTask.getMainTask().getMainTaskId())
                .isSuccess(subTask.getIsSuccess())
                .build();
    }

    public static List<SubTaskResDto> of(List<SubTask> subTaskList){
        return subTaskList.stream().map(SubTaskResDto::of).collect(Collectors.toList());
    }
}
