package com.example.post.service;

import com.example.post.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();

    @Override
    public void createUser(User user) {
        user.setId((long) (userList.size() + 1)); // 간단한 ID 할당
        userList.add(user);
    }

    @Override
    public User getUser(Long id) {
        // id가 1부터 시작한다고 가정하고, 0-based 인덱스로 변환
        if (id < 1 || id > userList.size()) {
            throw new IllegalArgumentException("유효하지 않은 사용자 ID입니다.");
        }
        return userList.get(Math.toIntExact(id) - 1); // id를 0-based 인덱스로 조정
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
