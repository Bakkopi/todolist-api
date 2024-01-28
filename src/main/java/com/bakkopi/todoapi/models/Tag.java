package com.bakkopi.todoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TAG")
@Data
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Pattern(regexp = "^#([A-Fa-f\\d]{6}|[A-Fa-f\\d]{3})$") // 3/6 digit hex code accepted
    private String hexCode = "#FAF9F6";

//    TODO: Bring Tags to user-level (i.e. Each user has their own collection of Tags)
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference("tag_user")  // Prevent infinite recursion w/ User
//    private User user;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
//    @JsonBackReference("task_tag")
    @JsonIgnore
    private Set<Task> tasks = new HashSet<>();

    public Tag(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }
}
