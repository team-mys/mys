package com.todo.demo.domain.task.main.repository;

import com.todo.demo.domain.task.main.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainTaskRepository extends JpaRepository<MainTask, Long> {
}
