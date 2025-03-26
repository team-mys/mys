package com.todo.demo.domain.user;

import com.todo.demo.domain.user.dto.UserEditDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "user_nick_name")
    private String userNickName;

    @Column(name = "user_password")
    private String userPassword;

    public void encodedUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public void updateUserEditInfo(String updateUserNickName, String userPassword){
        this.userNickName = updateUserNickName;
        this.userPassword = userPassword;
    }

    public void updateUserNickName(String updateUserNickName){
        this.userNickName = updateUserNickName;
    }
}
