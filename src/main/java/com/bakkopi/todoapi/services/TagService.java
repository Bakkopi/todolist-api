package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.Task;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.repositories.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserService userService;
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
    public List<String> getAllTagNames() {
        return tagRepository.findAllTagNames();
    }

//    public List<Tag> getUserTags(User user) {
//        return tagRepository.findByUser(user);
//    }

    public Tag createNewTag(@Valid Tag tag) {
//        tag.setUser(userService.getCurrentUser());
        return tagRepository.save(tag);
    }

//    public List<Tag> getTagsByUsername(String username) {
//        return tagRepository.findByUserUsername(username);
//    }

    public Tag getTagById(Long tagId) {
        return tagRepository.findById(tagId).get();
    }

    public Tag updateTag(@Valid Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    public Tag getTagByName(String tagName) {
        return tagRepository.findByName(tagName);
    }
}
