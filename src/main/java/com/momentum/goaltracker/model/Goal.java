package com.momentum.goaltracker.model;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Goal {
    private String name; // goal name/ title of the goal/ very short summary of the goal if can better be stated in more words
    private String criteria;

    public  Goal(String name, String criteria) {
        this.name = name;
        this.criteria = criteria;
    }

    // Getters and Setters
    public String getName(){
        return this.name;
    }

    public String getCriteria(){
        return this.criteria;
    }
}