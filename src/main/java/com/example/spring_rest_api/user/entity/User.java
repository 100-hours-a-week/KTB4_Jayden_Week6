package com.example.spring_rest_api.user.entity;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Long userId;
    private String email;
    private String password;
    private String nickname;
    private String profileImage;
    private boolean isUserDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime informationUpdatedAt;
    private LocalDateTime passwordUpdatedAt;
    private LocalDateTime deletedAt;

    public static User create(Long userId, String email, String password, String nickname, String profileImage) {
        User user = new User();
        user.userId = userId;
        user.email = email;
        user.password = password;
        user.nickname = nickname;
        user.profileImage = profileImage;
        user.isUserDeleted = false;
        user.createdAt = LocalDateTime.now();
        user.informationUpdatedAt = user.createdAt;
        user.passwordUpdatedAt = user.createdAt;
        user.deletedAt = null;
        return user;
    }

    public User updateInformation(String nickname, String profileImage) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.informationUpdatedAt = LocalDateTime.now();
        return this;
    }

    public User updatePassword(String password) {
        this.password = password;
        this.passwordUpdatedAt = LocalDateTime.now();
        return this;
    }

    public User delete() {
        this.isUserDeleted = true;
        this.deletedAt = LocalDateTime.now();
        return this;
    }
}
