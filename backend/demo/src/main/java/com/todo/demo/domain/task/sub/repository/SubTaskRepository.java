package com.todo.demo.domain.task.sub.repository;

import com.todo.demo.domain.task.sub.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
