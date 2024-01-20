package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getCurrentUserTasks(User user) {
        User currentUser = userService.getCurrentUser();
        return taskRepository.findByUser(user);
    }

    public Object getUserTasks(String username) {
        return taskRepository.findByUserUsername(username);
    }

    public Task getTaskById(Long id) {
        return taskRepository.getReferenceById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }


}
