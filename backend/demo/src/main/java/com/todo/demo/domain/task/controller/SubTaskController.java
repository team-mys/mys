package com.todo.demo.domain.task.controller;

import com.todo.demo.domain.task.sub.dto.SubTaskReqDto;
import com.todo.demo.domain.task.sub.dto.SubTaskResDto;
import com.todo.demo.domain.task.sub.service.SubTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "서브 테스크 관리 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/subtask")
@RestController
public class SubTaskController {
    private final SubTaskService subTaskService;

    @Operation(summary = "서브 테스크 등록", description = "메인 테스크보다 상세한 서브 테스크를 생성합니다.")
    @PostMapping
    public SubTaskResDto createSubTask(@RequestBody SubTaskReqDto subTaskReqDto){
        return subTaskService.createSubTask(subTaskReqDto);
    }
}
