package com.todo.demo.domain.task.repository;

import com.todo.demo.domain.task.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
