package com.todo.demo.domain.task.controller;

import com.todo.demo.domain.task.main.dto.MainTaskReqDto;
import com.todo.demo.domain.task.main.dto.MainTaskResDto;
import com.todo.demo.domain.task.main.service.MainTaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "메인 태스크 API ")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/maintask")
public class MainTaskController {
    private final MainTaskService mainTaskService;
    @PostMapping
    public MainTaskResDto createMainTask(@RequestBody MainTaskReqDto mainTaskReqDto){
        return mainTaskService.createMainTask(mainTaskReqDto);
    }
}
