package com.example.spring_rest_api.authorization.service.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AuthResponse {
    private String token;

    public static AuthResponse from(String token) {
        AuthResponse response = new AuthResponse();
        response.token = token;
        return response;
    }
}
