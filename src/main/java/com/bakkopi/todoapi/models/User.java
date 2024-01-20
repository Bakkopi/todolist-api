package com.bakkopi.todoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // OneToMany - tags is not a column in User table
    // mappedBy - indicates the column in Tag table where User ID is an FK
    // cascade - propagate actions from User to Tag (e.g. User deleted, tags also deleted)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference  // Prevent infinite recursion w/ Tag
    private Set<Tag> tags;

    public User() {}

    public User(String username, String password, String address, Gender gender) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.tags = new HashSet<>();
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
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
