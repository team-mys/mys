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

    private String subTaskTitle;

    private String subTaskContent;

    private long main_task_id;

    public static SubTaskResDto of(SubTask subTask){
        return SubTaskResDto.builder()
                .subTaskId(subTask.getSubTaskId())
                .subTaskContent(subTask.getSubTaskContent())
                .subTaskTitle(subTask.getSubTaskTitle())
                .main_task_id(subTask.getMainTask().getMainTaskId())
                .build();
    }

    public static List<SubTaskResDto> of(List<SubTask> subTaskList){
        return subTaskList.stream().map(SubTaskResDto::of).collect(Collectors.toList());
    }
}
