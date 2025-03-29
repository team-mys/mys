package com.todo.demo.domain.task.controller;

import com.todo.demo.domain.task.main.MainTask;
import com.todo.demo.domain.task.main.dto.MainStatusUpdateDto;
import com.todo.demo.domain.task.main.dto.MainTaskReqDto;
import com.todo.demo.domain.task.main.dto.MainTaskResDto;
import com.todo.demo.domain.task.main.dto.MainTaskUpdateDto;
import com.todo.demo.domain.task.main.service.MainTaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "메인 태스크 API ")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/maintask")
public class MainTaskController {
    private final MainTaskService mainTaskService;

    @GetMapping("/{userId}")
    public List<MainTaskResDto> getMyMainTask(@PathVariable Long userId){
        return mainTaskService.getAllMainTaskByUserId(userId);
    }

    @DeleteMapping("/{mainTaskId}")
    public void deleteMainTask(@PathVariable Long mainTaskId){
        mainTaskService.deleteMainTaskById(mainTaskId);
    }

    @PutMapping("/update")
    public MainTaskResDto updateMainTaskStatus(@RequestBody @Valid MainStatusUpdateDto statusUpdateDto){
        return mainTaskService.updateMainTaskStatus(statusUpdateDto);
    }

    @PutMapping
    public MainTaskResDto updateMainTask(@RequestBody MainTaskUpdateDto mainTaskUpdateDto){
        return mainTaskService.updateMainTask(mainTaskUpdateDto);
    }

    @PostMapping
    public MainTaskResDto createMainTask(@RequestBody MainTaskReqDto mainTaskReqDto){
        return mainTaskService.createMainTask(mainTaskReqDto);
    }
}
