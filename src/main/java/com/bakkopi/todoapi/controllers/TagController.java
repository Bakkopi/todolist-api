package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.services.TagService;
import com.bakkopi.todoapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{tagId}")
    public List<Tag> getAllTags(@PathVariable String tagId) {
        return tagService.getAllTags();
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTag(@RequestBody Tag tag) {
        return new ResponseEntity(tagService.createNewTag(tag), HttpStatus.OK);
    }

}
