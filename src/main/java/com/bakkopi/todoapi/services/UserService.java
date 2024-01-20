package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.repositories.TagRepository;
import com.bakkopi.todoapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() {
//        return new User("","");
        return new User("","","", User.Gender.MALE);
    }

    public List<User> getAllTasks() {
        return userRepository.findAll();
    }
}
