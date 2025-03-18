//package com.todo.demo.domain.post;
//
//import com.todo.demo.domain.user.Users;
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//
//@Entity
//public class Post implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long postId;
//    private String postName;
//    private String postContent;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Users userId;
//}
