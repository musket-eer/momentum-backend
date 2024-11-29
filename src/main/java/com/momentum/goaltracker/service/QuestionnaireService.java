package com.momentum.goaltracker.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class to generate questionnaires for goals.
 */
@Service
public class QuestionnaireService {

    /**
     * Generates a questionnaire for the given list of goals.
     *
     * @param goals List of goal names.
     * @return A map where each goal is mapped to its corresponding questions.
     */
    public Map<String, List<String>> generateQuestionnaire(List<String> goals) {
        Map<String, List<String>> goalQuestions = new HashMap<>();

        for (String goal : goals) {
            // Mocked questions for each goal
            goalQuestions.put(goal, List.of(
                    "What progress have you made on " + goal + "?",
                    "How do you feel about your progress toward " + goal + "?",
                    "What obstacles are preventing you from achieving " + goal + "?"
            ));
        }

        return goalQuestions;
    }
}
