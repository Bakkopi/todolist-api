package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Task>> getUserTasks(@PathVariable String username) {
        return new ResponseEntity(taskService.getUserTasks(username), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity(taskService.createNewTask(task), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getTask(@PathVariable Long id) {
        return new ResponseEntity(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return new ResponseEntity(taskService.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity(true, HttpStatus.OK);
    }
}

