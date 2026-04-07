package com.akshatha.code_execution_engine.controller;

import org.springframework.web.bind.annotation.*;

import com.akshatha.code_execution_engine.entity.*;
import com.akshatha.code_execution_engine.repository.*;

@RestController
@RequestMapping("/api/testcases")
@CrossOrigin
public class TestCaseController {

    private final TestCaseRepository repo;
    private final ProblemRepository problemRepo;

    public TestCaseController(TestCaseRepository repo, ProblemRepository problemRepo) {
        this.repo = repo;
        this.problemRepo = problemRepo;
    }

    @PostMapping
    public TestCaseEntity add(@RequestBody TestCaseEntity tc) {

        Problem p = problemRepo.findById(tc.getProblem().getId())
                .orElseThrow();

        tc.setProblem(p);

        return repo.save(tc);
    }
}