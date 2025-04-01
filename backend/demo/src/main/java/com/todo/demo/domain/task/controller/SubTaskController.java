package com.todo.demo.domain.task.controller;

import com.todo.demo.domain.task.sub.dto.SubTaskReqDto;
import com.todo.demo.domain.task.sub.dto.SubTaskResDto;
import com.todo.demo.domain.task.sub.dto.SubTaskUpdateDto;
import com.todo.demo.domain.task.sub.service.SubTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "서브 테스크 수정", description = "서브 테스크를 업데이트 합니다. 데이터는 mainTaskId, content, status가 존재합니다.")
    @PutMapping
    public SubTaskResDto updateSubTask(@RequestBody SubTaskUpdateDto subTaskUpdateDto){
        return subTaskService.updateSubTask(subTaskUpdateDto);
    }

    @Operation(summary = "서브 테스크 삭제")
    @DeleteMapping("/{subTaskId}")
    public void deleteSubTask(@PathVariable Long subTaskId){
        subTaskService.deleteSubTaskById(subTaskId);
    }

    @Operation(summary = "SubTask before or success", description = "boolean 값으로 todo 상태 토글 success, before 상태변경")
    @PatchMapping("/{subTaskId}")
    public SubTaskResDto updateIsSuccess(@PathVariable Long subTaskId){
        return subTaskService.updateSubTaskIsSuccess(subTaskId);
    }

    @Operation(summary = "메인 테스크 id로 서브 테스크 목록 조회", description = "mainTaskId에 해당하는 subTaskList를 반환합니다.")
    @GetMapping("/{mainTaskId}")
    public List<SubTaskResDto> getSubTaskList(@PathVariable Long mainTaskId){
        return subTaskService.getSubTaskListByMainTaskId(mainTaskId);
    }
}
