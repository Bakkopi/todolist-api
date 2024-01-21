package com.bakkopi.todoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    public enum Gender { MALE, FEMALE }

    // TODO: Add functionality for enum UserRole { USER, ADMIN }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    // OneToMany - tasks is not a column in User table
    // mappedBy - indicates the column in Task table where User ID is an FK
    // cascade - propagate actions from User to Task (e.g. User deleted, tasks also deleted)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonBackReference("task_user")
    private Set<Task> tasks = new HashSet<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonBackReference("tag_user")  // Prevent infinite recursion w/ Tag
//    private Set<Tag> tags = new HashSet<>();

    public User() {}

    public User(String username, String password, String address, Gender gender) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
