package com.example.smartdelivery.controller;

import com.example.smartdelivery.model.User;
import com.example.smartdelivery.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public TokenResponse register(@RequestBody User user) {
        String token = authService.register(user);
        return new TokenResponse(token);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest req) {
        String token = authService.login(req.username, req.password);
        return new TokenResponse(token);
    }

    @Data
    static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    static class TokenResponse {
        private String token;
        public TokenResponse(String token) { this.token = token; }
    }
}
