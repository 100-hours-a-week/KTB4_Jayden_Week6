package com.example.spring_rest_api.user.service;

import com.example.spring_rest_api.user.entity.User;
import com.example.spring_rest_api.user.repository.UserMemoryRepository;
import com.example.spring_rest_api.user.service.request.UserCreateRequest;
import com.example.spring_rest_api.user.service.request.UserUpdateRequest;
import com.example.spring_rest_api.user.service.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMemoryRepository userMemoryRepository;
    private Long sequence = 0L;

    public UserResponse create(UserCreateRequest request) {
        return UserResponse.from(userMemoryRepository.create(User.create(
                sequence++,
                request.getEmail(),
                request.getPassword(),
                request.getNickname(),
                request.getProfileImage()
        )));
    }

    public UserResponse read(Long userId) {
        return UserResponse.from(userMemoryRepository.findById(userId));
    }

    public UserResponse updateInformation(Long userId, UserUpdateRequest request) {
        return UserResponse.from(userMemoryRepository.update(
                userId,
                userMemoryRepository.findById(userId).updateInformation(
                        request.getNickname(),
                        request.getProfileImage()
                )
        ));
    }

    public UserResponse updatePassword(Long userId, UserUpdateRequest request) {
        return UserResponse.from(userMemoryRepository.update(
                userId,
                userMemoryRepository.findById(userId).updatePassword(
                        request.getPassword()
                )
        ));
    }

    public UserResponse delete(Long userId) {
        return UserResponse.from(userMemoryRepository.delete(userId));
    }
}
