package com.example.smartdelivery.service;

import com.example.smartdelivery.model.User;
import com.example.smartdelivery.repository.UserRepository;
import com.example.smartdelivery.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole() == null ? "USER" : user.getRole());
        userRepository.save(user);
        return jwtUtil.generateToken(user.getUsername());
    }

    public String login(String username, String password) {
        Optional<User> u = userRepository.findByUsername(username);
        if (u.isEmpty()) throw new RuntimeException("Invalid credentials");
        if (!passwordEncoder.matches(password, u.get().getPassword())) throw new RuntimeException("Invalid credentials");
        return jwtUtil.generateToken(username);
    }
}
