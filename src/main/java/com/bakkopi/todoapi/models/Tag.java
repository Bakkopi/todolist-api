package com.bakkopi.todoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hexCode;

//    TODO: Bring Tags to user-level (i.e. Each user has their own collection of Tags)
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference("tag_user")  // Prevent infinite recursion w/ User
//    private User user;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
//    @JsonBackReference("task_tag")
    @JsonIgnore
    private Set<Task> tasks = new HashSet<>();

    public Tag() {};

    public Tag(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
