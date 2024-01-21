package com.bakkopi.todoapi.repositories;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.Task.TaskStatus;
import com.bakkopi.todoapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    List<Task> findByUser(User user);
    List<Task> findByUserUsername(String username);

    // --- Filter ---
    List<Task> findByTagsIn(Set<Tag> tags);
    List<Task> findByDueDateEquals(LocalDate dueDate);
    List<Task> findByStatusEquals(TaskStatus status);

    // --- Sort ---
    List<Task> findAllByOrderByDueDateAsc();
    List<Task> findAllByOrderByDueDateDesc();
    List<Task> findAllByOrderByStatusAsc();
    List<Task> findAllByOrderByStatusDesc();
    List<Task> findAllByOrderByTaskNameAsc();
    List<Task> findAllByOrderByTaskNameDesc();
}

