package com.example.spring_rest_api.authorization.service.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AuthRequest {
    private String email;
    private String password;
    private String token;
}
