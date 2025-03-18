package com.todo.demo.domain.post;

import com.todo.demo.domain.user.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "main_post")
public class MainPost {

    @Id @Column(name = "main_post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainPostId;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "post_content")
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
}
