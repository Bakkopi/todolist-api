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
    public ResponseEntity<List<Tag>> getAllTags() {
        return new ResponseEntity(tagService.getAllTags(), HttpStatus.OK);
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<List<Tag>> getTagById(@PathVariable Long tagId) {
        return new ResponseEntity(tagService.getTagById(tagId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return new ResponseEntity(tagService.createNewTag(tag), HttpStatus.OK);
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long tagId, @RequestBody Tag tag) {
        tag.setId(tagId);
        return new ResponseEntity(tagService.updateTag(tag), HttpStatus.OK);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Boolean> deleteTag(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
        return new ResponseEntity(true, HttpStatus.OK);
    }

}
