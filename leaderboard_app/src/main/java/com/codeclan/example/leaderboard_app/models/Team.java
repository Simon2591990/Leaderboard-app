package com.codeclan.example.leaderboard_app.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Long id;
    private String name;
    private List<Player> players;
    private String result;
    private int goals;
    private Match match;


    public Team(String name, Match match) {
        this.name = name;
        this.players = new ArrayList<Player>();
        this.result = "";
        this.goals = 0;
        this.match = match;
    }

    public Team(){
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
