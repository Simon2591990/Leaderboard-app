package com.codeclan.example.leaderboard_app.models;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private Long id;

    private int gameNumber;

    private List<Team> teams;

    private Season season;


    public Match(int gameNumber, Season season) {
        this.gameNumber = gameNumber;
        this.season = season;
        this.teams = new ArrayList<Team>();
    }
    public Match(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
