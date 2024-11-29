package com.momentum.goaltracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GoalController {

    private final Map<Integer, String> goalsWithCriteria = new HashMap<>();

    // Constructor to initialize mock data
    public GoalController() {
        // Preloading mock data for testing
        goalsWithCriteria.put(1, "Run a 5k in under 30 minutes");
        goalsWithCriteria.put(2, "Learn Java programming with 5 small projects");
        goalsWithCriteria.put(3, "Read 10 books by the end of the year");
    }

    /**
     * Handles GET requests to fetch all goals and their criteria.
     *
     * @return A map of all stored goals and their criteria.
     */
    @GetMapping("/startup")
    public ResponseEntity<Map<Integer, String>> getGoalsWithCriteria() {
        return ResponseEntity.ok(goalsWithCriteria);
    }

    /**
     * Handles POST requests to add new goals with criteria.
     *
     * @param goals A map of goal numbers to their criteria.
     * @return A success message.
     */
    @PostMapping("/startup")
    public ResponseEntity<String> addGoalsWithCriteria(@RequestBody Map<Integer, String> goals) {
        if (goals == null || goals.isEmpty()) {
            return ResponseEntity.badRequest().body("Goals cannot be empty.");
        }

        goalsWithCriteria.putAll(goals);
        return ResponseEntity.ok("Goals and criteria successfully added!");
    }
}
