package com.chatapp.controller;

import com.chatapp.model.User;
import com.chatapp.repository.UserRepository;
import com.chatapp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwt;

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setStatus("OFFLINE");
        repo.save(user);
        return "User Registered";
    }

    // ✅ LOGIN
    @PostMapping("/login")
public String login(@RequestBody User user) {

    System.out.println("Login attempt: " + user.getUsername());

    User dbUser = repo.findByUsername(user.getUsername()).orElse(null);

    if (dbUser == null) {
        return "User not found";
    }

    if (!dbUser.getPassword().equals(user.getPassword())) {
        return "Invalid password";
    }

    try {
        return jwt.generateToken(user.getUsername()); // ✅ JWT
    } catch (Exception e) {
        e.printStackTrace(); // 🔥 IMPORTANT (shows real error)
        return "JWT error: " + e.getMessage();
    }
}
    @PostMapping("/logout")
public String logout(@RequestBody User user) {

    User dbUser = repo.findByUsername(user.getUsername()).orElse(null);

    if (dbUser != null) {
        dbUser.setStatus("OFFLINE");
        repo.save(dbUser);
    }

    return "Logged out";
}
}