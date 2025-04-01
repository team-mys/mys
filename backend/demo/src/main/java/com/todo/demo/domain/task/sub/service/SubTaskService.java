package com.todo.demo.domain.task.sub.service;

import com.todo.demo.domain.task.main.MainTask;
import com.todo.demo.domain.task.sub.SubTask;
import com.todo.demo.domain.task.sub.dto.SubTaskReqDto;
import com.todo.demo.domain.task.sub.dto.SubTaskResDto;
import com.todo.demo.domain.task.main.repository.MainTaskRepository;
import com.todo.demo.domain.task.sub.dto.SubTaskUpdateDto;
import com.todo.demo.domain.task.sub.repository.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<SubTaskResDto> getSubTaskListByMainTaskId(Long mainTaskId){
        return SubTaskResDto.of(subTaskRepository.getSubTasksByMainTaskMainTaskId(mainTaskId));
    }

    public SubTaskResDto updateSubTask(SubTaskUpdateDto subTaskUpdateDto){
        SubTask findSubTask = subTaskRepository.findById(subTaskUpdateDto.getSubTaskId()).get();
        MainTask findMainTask = mainTaskRepository.findById(subTaskUpdateDto.getMainTaskId()).get();

        findSubTask.toDo(findMainTask, subTaskUpdateDto.getSubTaskContent(), subTaskUpdateDto.getSubTaskStatus());
        SubTask updateSubTask = subTaskRepository.save(findSubTask);
        return SubTaskResDto.of(updateSubTask);
    }

    public void deleteSubTaskById(long subTaskId){
        subTaskRepository.deleteById(subTaskId);
    }




}
