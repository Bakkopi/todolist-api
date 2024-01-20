package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

//    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String sortBy,
//                                                  @RequestParam(required = false, defaultValue = "true") boolean sortAscend) {
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(){
        String[] validSortBy = {"dueDate", "status", "taskName"};
        // send sortBy and sortAscend as parameters into getAllTasks
        return new ResponseEntity(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<List<Task>> getTaskById(@PathVariable Long taskId) {
        return new ResponseEntity(taskService.getTaskById(taskId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
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

