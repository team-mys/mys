package com.todo.demo.domain.task.dto;

import com.todo.demo.domain.task.SubTask;
import lombok.Builder;
import lombok.Data;

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
}
