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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<SubTask> subTasksByMainTask = subTaskRepository.getSubTasksByMainTaskMainTaskId(mainTaskId);
        List<SubTask> sortedSubTask = subTasksByMainTask.stream().sorted(Comparator.comparing(SubTask::getSubTaskId)).collect(Collectors.toList());
        return SubTaskResDto.of(sortedSubTask);
    }

    public SubTaskResDto updateSubTask(SubTaskUpdateDto subTaskUpdateDto){
        SubTask findSubTask = subTaskRepository.findById(subTaskUpdateDto.getSubTaskId()).get();
        MainTask findMainTask = mainTaskRepository.findById(subTaskUpdateDto.getMainTaskId()).get();

        findSubTask.refreshSubTask(findMainTask, subTaskUpdateDto.getSubTaskContent());
        SubTask updateSubTask = subTaskRepository.save(findSubTask);
        return SubTaskResDto.of(updateSubTask);
    }

    public SubTaskResDto updateSubTaskIsSuccess(Long subTaskId){
        SubTask findSubTask = subTaskRepository.findById(subTaskId).get();
        findSubTask.todo();
        SubTask saveSubTask = subTaskRepository.save(findSubTask);
        return SubTaskResDto.of(saveSubTask);
    }

    public void deleteSubTaskById(long subTaskId){
        subTaskRepository.deleteById(subTaskId);
    }

}
