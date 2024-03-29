package com.bakkopi.todoapi.repositories;

import com.bakkopi.todoapi.models.Tag;
import com.bakkopi.todoapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findByName(String name);
    @Query("SELECT t.name FROM Tag t")
    List<String> findAllTagNames();

//    List<Tag> findByUser(User user);
//    List<Tag> findByUserUsername(String username);
}
