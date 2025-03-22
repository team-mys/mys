package com.todo.demo.domain.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder @Getter
@Table(name = "sub_task")
public class SubTask {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_task_id")
    private Long subTaskId;

    @Column(name = "sub_task_title")
    private String subTaskTitle;

    @Column(name = "sub_task_content")
    private String subTaskContent;

    @ManyToOne
    @JoinColumn(name = "main_task_id")
    private MainTask mainTask;

    public void updateMainTask(MainTask mainTask){
        this.mainTask = mainTask;
    }

}
