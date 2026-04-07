package com.akshatha.code_execution_engine.controller;

import org.springframework.web.bind.annotation.*;

import com.akshatha.code_execution_engine.dto.LeaderboardDTO;
import com.akshatha.code_execution_engine.service.LeaderboardService;

import java.util.List;

@RestController
@CrossOrigin
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/api/leaderboard")
    public List<LeaderboardDTO> getLeaderboard() {
        return leaderboardService.getLeaderboard();
    }
}