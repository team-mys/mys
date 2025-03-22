package com.todo.demo.domain.task.service;

import com.todo.demo.domain.task.MainTask;
import com.todo.demo.domain.task.SubTask;
import com.todo.demo.domain.task.dto.SubTaskReqDto;
import com.todo.demo.domain.task.dto.SubTaskResDto;
import com.todo.demo.domain.task.repository.MainTaskRepository;
import com.todo.demo.domain.task.repository.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubTaskService {
    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;

    public SubTaskResDto createSubTask(SubTaskReqDto taskReqDto){
        SubTask reqSubTask = taskReqDto.asSubTask();

        MainTask findMainTask = mainTaskRepository.findById(taskReqDto.getMainTaskId()).get();
        reqSubTask.updateMainTask(findMainTask);

        SubTask saveSubTask = subTaskRepository.save(reqSubTask);
        return SubTaskResDto.of(saveSubTask);
    }


}
