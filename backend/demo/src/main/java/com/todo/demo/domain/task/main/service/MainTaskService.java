package com.todo.demo.domain.task.main.service;

import com.todo.demo.domain.task.main.MainTask;
import com.todo.demo.domain.task.main.dto.MainTaskReqDto;
import com.todo.demo.domain.task.main.dto.MainTaskResDto;
import com.todo.demo.domain.task.main.dto.MainTaskUpdateDto;
import com.todo.demo.domain.task.main.repository.MainTaskRepository;
import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainTaskService {
    private final MainTaskRepository mainTaskRepository;
    private final UserRepository userRepository;

    public MainTaskResDto createMainTask(MainTaskReqDto mainTaskReqDto){
        MainTask reqMainTask = mainTaskReqDto.asMainTask();
        Users findUsers = userRepository.findById(mainTaskReqDto.getUserId()).get();
        reqMainTask.updateUsers(findUsers);
        return MainTaskResDto.of(mainTaskRepository.save(reqMainTask));
    }

    @Transactional
    public MainTaskResDto updateMainTask(MainTaskUpdateDto mainTaskUpdateDto){
        MainTask findMainTask = mainTaskRepository.findById(mainTaskUpdateDto.getMainTaskId()).get();

        Long userId = mainTaskUpdateDto.getUserId();
        Optional<Users> findUser = userRepository.findById(userId);
        findMainTask.updateUsers(findUser.get());
        findMainTask.refreshTask(mainTaskUpdateDto.getMainTaskContent());
        MainTask updateMainTask = mainTaskRepository.save(findMainTask);

        return MainTaskResDto.of(updateMainTask);
    }

//    @Transactional
//    public MainTaskResDto updateMainTaskStatus(MainStatusUpdateDto dto){
//        MainTask findMainTask = mainTaskRepository.findById(dto.getMainTaskId()).get();
//        findMainTask.updateStatus(dto.toEnum());
//        return MainTaskResDto.of(mainTaskRepository.save(findMainTask));
//    }

    @Transactional(readOnly = true)
    public List<MainTaskResDto> getAllMainTaskByUserId(Long userId){
        List<MainTask> findMainTasks = mainTaskRepository.findAllByUsersUserId(userId);
        List<MainTask> sortedMainTask = findMainTasks.stream().sorted(Comparator.comparing(MainTask::getCreatedAt)).collect(Collectors.toList());
       return MainTaskResDto.of(sortedMainTask);
    }

    @Transactional
    public MainTaskResDto updateMainTaskIsSuccess(Long mainTaskId){
        MainTask findMainTask = mainTaskRepository.findById(mainTaskId).get();

        findMainTask.todo();
        return MainTaskResDto.of(mainTaskRepository.save(findMainTask));
    }

    @Transactional
    public void deleteMainTaskById(Long mainTaskId){
        mainTaskRepository.deleteById(mainTaskId);
    }
}
