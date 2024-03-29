package com.bakkopi.todoapi.services;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.User;
import com.bakkopi.todoapi.repositories.TagRepository;
import com.bakkopi.todoapi.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
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

    public User createNewUser(@Valid User user) {
        return userRepository.save(user);
    }

    public User updateUser(@Valid User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }
}
