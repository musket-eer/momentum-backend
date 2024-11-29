package com.momentum.goaltracker.controller;

import com.momentum.goaltracker.model.Questionnaire;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReflectionController {

    private final Map<String, Questionnaire> storedQuestionnaires = new HashMap<>(); // Simulates storage
    private final Map<String, Map<String, List<String>>> storedResponses = new HashMap<>(); // Simulates response storage

    /**
     * Handles GET requests to fetch user questions for reflection.
     *
     * @param userId The ID of the user.
     * @return The questionnaire for the user.
     */
    @GetMapping("/reflection")
    public Questionnaire getUserQuestions(@RequestParam("userId") String userId) {
        // Fetch the user's questionnaire
        Questionnaire questionnaire = storedQuestionnaires.get(userId);

        if (questionnaire == null) {
            throw new IllegalArgumentException("No questionnaire found for user: " + userId);
        }

        return questionnaire;
    }

    /**
     * Handles POST requests to save user responses to the questionnaire.
     *
     * @param userId    The ID of the user.
     * @param responses The user's responses to the questionnaire.
     * @return A confirmation message.
     */
    @PostMapping("/reflection")
    public String saveUserResponses(@RequestParam("userId") String userId,
                                    @RequestBody Map<String, List<String>> responses) {
        if (!storedQuestionnaires.containsKey(userId)) {
            throw new IllegalArgumentException("No questionnaire exists for user: " + userId);
        }

        // Save the responses with today's date as the key
        String today = LocalDate.now().toString();
        storedResponses.putIfAbsent(userId, new HashMap<>());
        storedResponses.get(userId).put(today, responses.get("responses"));

        return "Responses saved successfully for user " + userId + " on " + today;
    }
}
