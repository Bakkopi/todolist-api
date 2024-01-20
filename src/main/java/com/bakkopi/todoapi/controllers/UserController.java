package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.services.TagService;
import com.bakkopi.todoapi.services.TaskService;
import com.bakkopi.todoapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllTasks();
    }

    @GetMapping("/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @GetMapping("/me/tags")
    public List<Tag> getCurrentUserTags() {
        return tagService.getUserTags(getCurrentUser());
    }

    @GetMapping("/me/tasks")
    public ResponseEntity<List<Task>> getCurrentUserTasks() {
        return new ResponseEntity(taskService.getCurrentUserTasks(), HttpStatus.OK);
    }

    @GetMapping("/{username}/tasks")
    public ResponseEntity<List<Task>> getTasksByUsername(@PathVariable String username) {
        return new ResponseEntity(taskService.getTasksByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/{username}/tags")
    public ResponseEntity<List<Tag>> getTagsByUsername(@PathVariable String username) {
        return new ResponseEntity(tagService.getTagsByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Tag> createTag(@RequestBody Task task) {
        return new ResponseEntity(taskService.createNewTask(task), HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        task.setId(taskId);
        return new ResponseEntity(taskService.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity(true, HttpStatus.OK);
    }
}
