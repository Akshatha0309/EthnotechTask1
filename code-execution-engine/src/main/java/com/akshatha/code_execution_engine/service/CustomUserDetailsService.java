package com.akshatha.code_execution_engine.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.akshatha.code_execution_engine.entity.User;
import com.akshatha.code_execution_engine.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findFirstByUsernameIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // already encoded
                .roles("USER")
                .build();
    }
}