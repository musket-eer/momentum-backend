package com.momentum.goaltracker.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, String> users = new HashMap<>(); // Mock user store

    public CustomUserDetailsService() {
        // Preload a test user (username: admin, password: admin123)
        users.put("admin", "$2a$10$7QwFZZZQ.ygltYjrmY08ReK/VzUb5IDBdBFe5OB2KQqjjDRO2RxYy"); // BCrypt hash for "admin123"
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = users.get(username);
        if (password == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(username).password(password).roles("USER").build();
    }

    public void saveUser(String username, String password) {
        users.put(username, password);
    }
}
