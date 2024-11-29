package com.momentum.goaltracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GoalProgressController {

    @GetMapping("/dashboard")
    public ResponseEntity<List<Map<String, Object>>> getDashboardData() {
        // Mock data
        List<Map<String, Object>> dashboardData = Arrays.asList(
                Map.of(
                        "id", 1,
                        "name", "Read 10 pages daily",
                        "description", "Daily reading habit",
                        "scores", Arrays.asList(
                                Map.of("day", "Mon", "score", 3),
                                Map.of("day", "Tue", "score", 4),
                                Map.of("day", "Wed", "score", 5),
                                Map.of("day", "Thu", "score", 4),
                                Map.of("day", "Fri", "score", 4),
                                Map.of("day", "Sat", "score", 15),
                                Map.of("day", "Sun", "score", 4)
                        )
                ),
                Map.of(
                        "id", 2,
                        "name", "Exercise 30 minutes",
                        "description", "Daily workout",
                        "scores", Arrays.asList(
                                Map.of("day", "Mon", "score", 2),
                                Map.of("day", "Tue", "score", 3),
                                Map.of("day", "Wed", "score", 3),
                                Map.of("day", "Thu", "score", 4),
                                Map.of("day", "Fri", "score", 4),
                                Map.of("day", "Sat", "score", 5),
                                Map.of("day", "Sun", "score", 5)
                        )
                )
        );

        return ResponseEntity.ok(dashboardData);
    }
}
