package com.todo.demo.domain.task.main;

import com.todo.demo.domain.task.TaskStatus;
import com.todo.demo.domain.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "main_task")
public class MainTask {

    @Id @Column(name = "main_task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainTaskId;

    @Column(name = "main_task_content")
    private String mainTaskContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Enumerated(EnumType.STRING)
    @Column(name = "main_task_status")
    private TaskStatus mainTaskStatus;

    public void updateUsers(Users users){
        this.users = users;
    }
    public void refreshTask(String mainTaskContent){
        this.mainTaskContent = mainTaskContent;
    }
    public String parseStatus(){
        return this.mainTaskStatus.getStatusDescription();
    }

    public void updateStatus(TaskStatus taskStatus){
        this.mainTaskStatus = taskStatus;
    }

    @PrePersist
    protected void updateStartStatus(){
        this.mainTaskStatus = TaskStatus.PENDING;
    }
}
