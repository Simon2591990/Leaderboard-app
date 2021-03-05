package com.codeclan.example.leaderboard_app.models;

import java.util.ArrayList;
import java.util.List;

public class Season {

    private Long id;

    private String name;

    private int totalMatches;

    private List<Match> matches;

    public Season(String name, int totalMatches) {
        this.name = name;
        this.totalMatches = totalMatches;
        this.matches = new ArrayList<Match>();
    }

    public Season(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}

