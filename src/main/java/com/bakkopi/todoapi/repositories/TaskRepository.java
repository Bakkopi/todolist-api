package com.bakkopi.todoapi.repositories;

import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    List<Task> findByUser(User user);
    List<Task> findByUserUsername(String username);
}

