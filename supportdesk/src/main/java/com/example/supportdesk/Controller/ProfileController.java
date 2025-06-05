package com.example.supportdesk.Controller;

import com.example.supportdesk.Model.User;
import com.example.supportdesk.Security.JwtUtil;
import com.example.supportdesk.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    public ProfileController(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid or missing token"));
        }

        String token = authHeader.substring(7);
        if (!jwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid or expired token"));
        }

        String email = jwtUtil.extractEmail(token);
        Optional<User> user = userService.getUserByEmail(email); // user email

        return user.map(u -> ResponseEntity.ok(Map.of(
                "id", u.getId(),
                "name", u.getName(),
                "email", u.getEmail(),
                "role", u.getRole()
        ))).orElse(ResponseEntity.status(404).body(Map.of("message", "User not found")));
    }
}

