package com.example.post.service;

import com.example.post.model.User;
import com.example.post.repository.UserRepository;
import com.example.post.repository.UserRepositoryImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.create(user);
    }

    // 사용자 조회 메서드 (Optional을 사용하여 사용자 존재 여부 체크)
    public Optional<User> selectUser(Long id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAll();
    }
}
