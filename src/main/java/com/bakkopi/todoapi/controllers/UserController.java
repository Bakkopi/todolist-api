package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.services.TagService;
import com.bakkopi.todoapi.services.TaskService;
import com.bakkopi.todoapi.services.UserService;
import jakarta.validation.Valid;
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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllTasks();
    }

    @GetMapping("/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

//    @GetMapping("/me/tags")
//    public List<Tag> getCurrentUserTags() {
//        return tagService.getUserTags(getCurrentUser());
//    }

    @GetMapping("/me/tasks")
    public ResponseEntity<List<Task>> getCurrentUserTasks() {
        return new ResponseEntity(taskService.getCurrentUserTasks(), HttpStatus.OK);
    }

    @GetMapping("/{username}/tasks")
    public ResponseEntity<List<Task>> getTasksByUsername(@PathVariable String username) {
        return new ResponseEntity(taskService.getTasksByUsername(username), HttpStatus.OK);
    }

//    @GetMapping("/{username}/tags")
//    public ResponseEntity<List<Tag>> getTagsByUsername(@PathVariable String username) {
//        return new ResponseEntity(tagService.getTagsByUsername(username), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity(userService.createNewUser(user), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @Valid @RequestBody User user) {
        user.setId(userId);
        return new ResponseEntity(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(true, HttpStatus.OK);
    }
}
