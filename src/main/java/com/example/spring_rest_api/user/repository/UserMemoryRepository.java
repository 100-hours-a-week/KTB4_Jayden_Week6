package com.example.spring_rest_api.user.repository;

import com.example.spring_rest_api.common.exception.NotFoundException;
import com.example.spring_rest_api.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class UserMemoryRepository {
    private final Map<Long, User> userStorage = new ConcurrentHashMap<>();

    public User create(User user) {
        userStorage.put(user.getUserId(), user);
        return findById(user.getUserId());
    }

    public User findById(Long userId) {
        return Optional.ofNullable(userStorage.get(userId))
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
    }

    public User update(Long userId, User user) {
        userStorage.replace(userId, user);
        return findById(userId);
    }

    public User delete(Long userId) {
        User deleted = findById(userId).delete();
        userStorage.replace(userId, deleted);
        return findById(userId);
    }
}
