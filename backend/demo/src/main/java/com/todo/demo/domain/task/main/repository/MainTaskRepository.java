package com.todo.demo.domain.task.main.repository;

import com.todo.demo.domain.task.main.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MainTaskRepository extends JpaRepository<MainTask, Long> {
    List<MainTask> findAllByUsersUserName(String userName);
}
