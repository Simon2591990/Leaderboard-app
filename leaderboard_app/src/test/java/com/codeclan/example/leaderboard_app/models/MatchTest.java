package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    Team team1;
    Match match;
    ArrayList<Team> teams;
    Season season, season2;


    @BeforeEach
    void setUp() {
        teams = new ArrayList<Team>();
        season = new Season("Season 1",10);
        season2 = new Season("Season 2", 15);
        match = new Match(1, season);
    }

    @Test
    void getGameNumber() {
        assertEquals(1, match.getGameNumber());
    }

    @Test
    void setGameNumber() {
        match.setGameNumber(2);
        assertEquals(2, match.getGameNumber());
    }

    @Test
    void getTeams() {
        assertEquals(0, match.getTeams().size());
    }

    @Test
    void setTeams() {
        teams.add(team1);
        match.setTeams(teams);
        assertEquals(1, match.getTeams().size());
    }

    @Test
    void getSeason() {
        assertEquals("Season 1", match.getSeason().getName());
    }

    @Test
    void setSeason() {
        match.setSeason(season2);
        assertEquals("Season 2", match.getSeason().getName());
    }
}