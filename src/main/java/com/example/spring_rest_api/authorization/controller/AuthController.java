package com.example.spring_rest_api.authorization.controller;

import com.example.spring_rest_api.authorization.service.AuthService;
import com.example.spring_rest_api.authorization.service.request.AuthRequest;
import com.example.spring_rest_api.authorization.service.response.AuthResponse;
import com.example.spring_rest_api.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(ApiResponse.of(
                "login_success",
                authService.login(request)
        ));
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<ApiResponse<AuthResponse>> logout(@RequestBody AuthRequest request) {
        authService.logout(request);
        return ResponseEntity.ok(ApiResponse.of(
                "logout_success", null
        ));
    }
}
