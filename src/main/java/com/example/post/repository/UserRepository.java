package com.example.post.repository;

import com.example.post.model.User;

import java.util.List;

public interface UserRepository {
    void create(User user);

    List<User> selectAll();
}
