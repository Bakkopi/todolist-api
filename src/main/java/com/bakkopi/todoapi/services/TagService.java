package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
