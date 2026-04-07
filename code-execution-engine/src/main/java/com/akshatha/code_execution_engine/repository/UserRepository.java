package com.akshatha.code_execution_engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshatha.code_execution_engine.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUsernameIgnoreCase(String username);
    Optional<User> findByEmail(String email);
Optional<User> findByResetToken(String token);

    
}