package com.todo.demo.domain.task.repository;

import com.todo.demo.domain.task.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainTaskRepository extends JpaRepository<MainTask, Long> {
}
