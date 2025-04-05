package com.todo.demo.domain.task.sub;

import com.todo.demo.domain.task.main.MainTask;
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

    @Column(name = "sub_task_content")
    private String subTaskContent;

    @ManyToOne
    @JoinColumn(name = "main_task_id")
    private MainTask mainTask;

    @Column(name = "is_success")
    private Boolean isSuccess;

    public void updateMainTask(MainTask mainTask){
        this.mainTask = mainTask;
    }

    public void refreshSubTask(MainTask mainTask, String subTaskContent){
        this.mainTask = mainTask;
        this.subTaskContent = subTaskContent;
    }

    public void todo(){
        this.isSuccess = !this.isSuccess;
    }

    @PrePersist
    private void setDefaultIsSuccess(){
        this.isSuccess = false;
    }
}
