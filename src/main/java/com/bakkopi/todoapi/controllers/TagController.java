package com.bakkopi.todoapi.controllers;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.services.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TagController {
    private TagService tagService;

    @GetMapping("/")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

}
