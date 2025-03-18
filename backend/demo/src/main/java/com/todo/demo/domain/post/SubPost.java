package com.todo.demo.domain.post;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_post")
public class SubPost {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_post_id")
    private Long subPostId;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "post_content")
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "main_post_id")
    private MainPost mainPost;

}
