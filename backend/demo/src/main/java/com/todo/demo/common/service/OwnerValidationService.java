package com.todo.demo.common.service;

import com.todo.demo.domain.task.main.repository.MainTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerValidationService {
    private final MainTaskRepository mainTaskRepository;

    public boolean isOwner(Long userId, Long mainTaskId){
        return mainTaskRepository.findById(mainTaskId)
                .map(mainTask -> mainTask.getOwnerId().equals(userId))
                .orElse(false);
    }
}
