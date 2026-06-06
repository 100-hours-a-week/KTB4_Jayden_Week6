package com.example.spring_rest_api.user.service.response;

import com.example.spring_rest_api.user.entity.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserResponse {
    private String email;
    private String password;
    private String nickname;
    private String profileImage;
    private boolean isUserDeleted;


    public static UserResponse from(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.email = user.getEmail();
        userResponse.password = user.getPassword();
        userResponse.nickname = user.getNickname();
        userResponse.profileImage = user.getProfileImage();
        userResponse.isUserDeleted = user.isUserDeleted();
        return userResponse;
    }
}
