package com.bakkopi.todoapi.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    // TODO: public enum UserRole { USER, ADMIN }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Cascade actions from User to Tag (e.g. User deleted, tags also deleted)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Tag> tags;

    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
