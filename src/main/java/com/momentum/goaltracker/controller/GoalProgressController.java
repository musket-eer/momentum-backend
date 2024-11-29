package com.momentum.goaltracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GoalProgressController {

    /**
     * Handles GET requests to /dashboard and returns the progress of all goals.
     *
     * @return A list of goals and their progress.
     */
    @GetMapping("/dashboard")
    public List<Map<String, Object>> getGoalProgress() {
        // Simulating a database or service fetching updated goal progress
        List<Map<String, Object>> goalsProgress = new ArrayList<>();

        // Example goals with progress (can be replaced with a service call)
        goalsProgress.add(Map.of("goal", "Improve Fitness", "progress", 70));
        goalsProgress.add(Map.of("goal", "Learn Programming", "progress", 85));
        goalsProgress.add(Map.of("goal", "Read More Books", "progress", 50));

        return goalsProgress;
    }
}
