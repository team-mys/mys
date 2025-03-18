package com.todo.demo.domain.user;

import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    //AccessToken 수명 10분
}
