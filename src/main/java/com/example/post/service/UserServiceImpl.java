package com.example.post.service;

import com.example.post.exception.UserNotFoundException;
import com.example.post.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();

    @Override
    public void createUser(User user) {
        user.setId((long) (userList.size() + 1)); // 간단한 ID 할당
        userList.add(user);
    }

    // 사용자 조회 메서드 (Optional을 사용하여 사용자 존재 여부 체크)
    public Optional<User> getUser(Long id) {
        // id가 유효한 범위 내에 있는지 확인
        if (id < 1 || id > userList.size()) {
            return Optional.empty(); // 사용자 없음
        }
        // 사용자 리스트에서 0-based 인덱스로 사용자 반환
        return Optional.of(userList.get(Math.toIntExact(id) - 1)); // 0-based index
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
