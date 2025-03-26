package com.todo.demo.domain.task.main.service;

import com.todo.demo.domain.task.main.MainTask;
import com.todo.demo.domain.task.main.dto.MainTaskReqDto;
import com.todo.demo.domain.task.main.dto.MainTaskResDto;
import com.todo.demo.domain.task.main.repository.MainTaskRepository;
import com.todo.demo.domain.user.Users;
import com.todo.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void deleteMainTaskById(Long mainTaskId){
        mainTaskRepository.deleteById(mainTaskId);
    }
}
