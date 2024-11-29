package com.momentum.goaltracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GoalController {

    @PostMapping("/startup")
    public ResponseEntity<String> handleStartup(@RequestBody List<GoalRequest> goals) {
        goals.forEach(goal -> {
            System.out.println("ID: " + goal.getId());
            System.out.println("Goal: " + goal.getGoal());
            System.out.println("Criteria: " + goal.getCriteria());
        });

        return ResponseEntity.ok("Goals processed successfully!");
    }

    // Nested static class for simplicity; ideally, this would be in its own file.
    public static class GoalRequest {
        private int id;
        private String goal;
        private String criteria;

        // Getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGoal() {
            return goal;
        }

        public void setGoal(String goal) {
            this.goal = goal;
        }

        public String getCriteria() {
            return criteria;
        }

        public void setCriteria(String criteria) {
            this.criteria = criteria;
        }
    }
}
