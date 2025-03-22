package com.todo.demo.domain.task;

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

    @Column(name = "main_task_title")
    private String mainTaskTitle;

    @Column(name = "main_task_content")
    private String mainTaskContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public void updateUsers(Users users){
        this.users = users;
    }
}
