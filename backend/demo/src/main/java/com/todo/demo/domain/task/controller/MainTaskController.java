package com.todo.demo.domain.task.controller;

import com.todo.demo.domain.task.main.dto.MainTaskReqDto;
import com.todo.demo.domain.task.main.dto.MainTaskResDto;
import com.todo.demo.domain.task.main.dto.MainTaskUpdateDto;
import com.todo.demo.domain.task.main.service.MainTaskService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "할 일 목록 가져오기", description = "사용자가 작성한, userId에 해당하는 mainTaskList 반환")
    @GetMapping("/{userId}")
    public List<MainTaskResDto> getMyMainTask(@PathVariable Long userId){
        return mainTaskService.getAllMainTaskByUserId(userId);
    }

    @Operation(summary = "메인 작업 삭제", description = "mainTaskId에 해당하는 data 삭제")
    @DeleteMapping("/{mainTaskId}")
    public void deleteMainTask(@PathVariable Long mainTaskId){
        mainTaskService.deleteMainTaskById(mainTaskId);
    }

//    @Operation(summary = "메인 테스크 상태 업데이트", description = "사용자가 할 일을 생성할 떄는 '실행전'이라는 상태가 자동으로 들어가고, 진행중, 완료로 변경할 수 있다.")
//    @PutMapping("/update")
//    public MainTaskResDto updateMainTaskStatus(@RequestBody @Valid MainStatusUpdateDto statusUpdateDto){
//        return mainTaskService.updateMainTaskStatus(statusUpdateDto);
//    }

    @Operation(summary = "MainTask before or success", description = "boolean 값으로 todo 상태 토글 success, before 상태변경")
    @PatchMapping("/{mainTaskId}")
    public MainTaskResDto updateIsSuccess(@PathVariable Long mainTaskId){
        return mainTaskService.updateMainTaskIsSuccess(mainTaskId);
    }

    @Operation(summary = "사용자의 할 일을 수정한다.", description = "mainTaskId, mainTaskContent를 받아서 mainTask를 업데이트해준다. 반환 값은 업데이트한 MainTask 컬럼 값이다.")
    @PutMapping()
    public MainTaskResDto updateMainTask(@RequestBody MainTaskUpdateDto mainTaskUpdateDto){
        return mainTaskService.updateMainTask(mainTaskUpdateDto);
    }

    @Operation(summary = "메인 테스크를 생성할 수 있다.", description = "mainTaskId를 제외한 data를 받아 새로운 mainTask를 생성하고, 생성된 mainTask 반환")
    @PostMapping
    public MainTaskResDto createMainTask(@RequestBody MainTaskReqDto mainTaskReqDto){
        return mainTaskService.createMainTask(mainTaskReqDto);
    }
}
