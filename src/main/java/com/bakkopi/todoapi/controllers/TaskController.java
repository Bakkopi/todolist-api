package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.exception.ApiRequestException;
import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.Task.TaskStatus;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.services.TagService;
import com.bakkopi.todoapi.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/condition")
    public ResponseEntity<List<Task>> getTasksByCondition(@RequestParam(required = false) Set<String> tags,
                                                             @RequestParam(value = "dueDate", required = false) String dueDateString,
                                                             @RequestParam(value = "status", required = false) String statusString,
                                                             @RequestParam(required = false, defaultValue = "dueDate") String sortBy,
                                                             @RequestParam(required = false, defaultValue = "true") boolean sortAscend) {
        // Objects
        TaskStatus status = null;
        LocalDate dueDate = null;

        // ----- GET parameters checking -----
        List<String> validTags = tagService.getAllTagNames();
        List<String> validStatuses = Arrays.stream(Task.TaskStatus.values()).map(Enum::name).toList(); // Enum to String list
        List<String> validSortBy = Arrays.asList("duedate", "tags", "status");
        String isoDateRegex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";

        if (dueDateString != null) {
            if (dueDateString.matches(isoDateRegex)) {
                dueDate = LocalDate.parse(dueDateString);
            } else {
                throw new ApiRequestException("Invalid date format (Must be yyyy-MM-dd)");
            }
        }
        if (tags != null) {
            if (!validTags.containsAll(tags)) {
                throw new ApiRequestException("Invalid tag name(s)");
            }
        }
        if(statusString != null) {
            if (validStatuses.contains(statusString)) {
                status = TaskStatus.valueOf(statusString.toUpperCase());
            } else {
                throw new ApiRequestException("Invalid status. Only allows for " + validStatuses);
            }
        }
        if (sortBy != null) {
            if (!validSortBy.contains(sortBy.toLowerCase())) {
                throw new ApiRequestException("Invalid sortBy option");
            }
        }

        // TODO: Implement filter using JPA Specification
        Set<Tag> tagSet =
                tags != null ?
                tags.stream().map(tagName -> tagService.getTagByName(tagName)).collect(Collectors.toSet()) : null;
        return new ResponseEntity(taskService.getTasksByCondition(tagSet, dueDate, status, sortBy, sortAscend), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<List<Task>> getTaskById(@PathVariable Long taskId) {
        return new ResponseEntity(taskService.getTaskById(taskId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return new ResponseEntity(taskService.createNewTask(task), HttpStatus.OK);
    }

    @PostMapping("/{taskId}/tags")
    public ResponseEntity<Task> addTagToTask(@PathVariable Long taskId, @Valid @RequestBody Tag tag) {
        return new ResponseEntity(taskService.addTagToTask(taskId, tag), HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @Valid @RequestBody Task task) {
        task.setId(taskId);
        Task existingTask = taskService.getTaskById(taskId);
        task.setTags(existingTask.getTags());
        task.setUser(existingTask.getUser());
        return new ResponseEntity(taskService.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity(true, HttpStatus.OK);
    }
}

