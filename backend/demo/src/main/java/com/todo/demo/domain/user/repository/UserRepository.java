package com.todo.demo.domain.user.repository;

import com.todo.demo.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findUsersByUserName(String userName);

}
