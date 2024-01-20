package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserService userService;
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getUserTags(User user) {
        return tagRepository.findByUser(user);
    }

    public Tag createNewTag(Tag tag) {
//        tag.setUser(userService.getCurrentUser());
        return tagRepository.save(tag);
    }

    public List<Tag> getTagsByUsername(String username) {
        return tagRepository.findByUserUsername(username);
    }
}
