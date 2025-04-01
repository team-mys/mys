package com.todo.demo.domain.task.main;

import com.todo.demo.domain.BaseEntity;
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
public class MainTask extends BaseEntity {

    @Id @Column(name = "main_task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainTaskId;

    @Column(name = "main_task_content")
    private String mainTaskContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "is_success")
    private Boolean isSuccess;

    public void updateUsers(Users users){
        this.users = users;
    }
    public void refreshTask(String mainTaskContent){
        this.mainTaskContent = mainTaskContent;
    }

    public Long getOwnerId(){
        return this.users.getUserId();
    }
    public void todo(){
        this.isSuccess = !this.isSuccess;
    }
    @PrePersist
    protected void updateStartStatus(){
        this.isSuccess = false;
    }
}
