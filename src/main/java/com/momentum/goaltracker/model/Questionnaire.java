package com.momentum.goaltracker.model;
import java.util.List;
import java.util.Map;

public class Questionnaire {

    private Map<String, List<String>> goalQuestions; // Map of goal names to their questions
    private List<String> options; // Uniform multiple-choice options for all questions (optional)

    // Constructor
    public Questionnaire(Map<String, List<String>> goalQuestions, List<String> options) {
        this.goalQuestions = goalQuestions;
        this.options = options;
    }

    // Default Constructor
    public Questionnaire() {
    }

    // Getters and Setters
    public Map<String, List<String>> getGoalQuestions() {
        return goalQuestions;
    }

    public void setGoalQuestions(Map<String, List<String>> goalQuestions) {
        this.goalQuestions = goalQuestions;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "goalQuestions=" + goalQuestions +
                ", options=" + options +
                '}';
    }
}
