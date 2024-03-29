package com.bakkopi.todoapi.repositories;

import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User findByUsername(String username);
}
