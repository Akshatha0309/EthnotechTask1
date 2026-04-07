package com.akshatha.code_execution_engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshatha.code_execution_engine.entity.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}