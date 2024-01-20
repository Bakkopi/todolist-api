package com.bakkopi.todoapi.models;

import jakarta.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Tag() {};
    public Tag(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
