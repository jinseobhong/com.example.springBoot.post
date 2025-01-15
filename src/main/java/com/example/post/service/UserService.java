package com.example.post.service;

import com.example.post.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
