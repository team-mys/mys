package com.todo.demo.domain.task.sub.dto;

import com.todo.demo.domain.task.sub.SubTask;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubTaskReqDto {

    private String subTaskContent;
    private long mainTaskId;

    public SubTask asSubTask(){
        return SubTask.builder()
                .subTaskContent(subTaskContent)
                .build();
    }
}
