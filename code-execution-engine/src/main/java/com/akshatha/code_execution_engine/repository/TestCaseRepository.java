package com.akshatha.code_execution_engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshatha.code_execution_engine.entity.TestCaseEntity;

import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCaseEntity, Long> {

    List<TestCaseEntity> findByProblemId(Long problemId);
}