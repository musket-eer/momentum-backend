package com.momentum.goaltracker.controller;

import com.momentum.goaltracker.service.CustomUserDetailsService;
import com.momentum.goaltracker.model.LoginRequest;
import com.momentum.goaltracker.model.SignupRequest;
import com.momentum.goaltracker.model.ResetPasswordRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    CustomUserDetailsService userDetailsService,
                                    PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        System.out.println("SignUp receive this form");
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        userDetailsService.saveUser(request.getUsername(), encodedPassword);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/signup")
    public ResponseEntity<String> getSignupInfo() {
        return ResponseEntity.ok("Use POST to send 'username' and 'password' for signup.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam LoginRequest request) {
        System.out.println(request.toString());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            return ResponseEntity.ok("Login successful!");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> getLoginInfo() {
        System.out.println("Noice");
        return ResponseEntity.ok("Use POST to send 'username' and 'password' for login.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam ResetPasswordRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getNewPassword());
        userDetailsService.saveUser(request.getUsername(), encodedPassword);
        return ResponseEntity.ok("Password reset successfully!");
    }

    @GetMapping("/reset-password")
    public ResponseEntity<String> getResetPasswordInfo() {
        return ResponseEntity.ok("Use POST to send 'username' and 'newPassword' to reset your password.");
    }
}
