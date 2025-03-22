package com.todo.demo.domain.task.service;

import com.todo.demo.domain.task.MainTask;
import com.todo.demo.domain.task.dto.MainTaskReqDto;
import com.todo.demo.domain.task.dto.MainTaskResDto;
import com.todo.demo.domain.task.repository.MainTaskRepository;
import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
