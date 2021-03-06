package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    Team team;
    Player player1, player2, player3;
    Match match1, match2;
    Season season;



    @BeforeEach
    void setUp() {
        season = new Season("Season 1",10);
        match1 = new Match(1, season);
        match2 = new Match(2, season);
        team = new Team("Team1", match1);
    }

    @Test
    void getName() {
        assertEquals("Team1", team.getName());
    }

    @Test
    void setName() {
        team.setName("Team2");
        assertEquals("Team2", team.getName());
    }

    @Test
    void getPlayers() {
        assertEquals(0, team.getPlayers().size());
    }

    @Test
    void setPlayers() {
        ArrayList<Player> players2 = new ArrayList<Player>();
         players2.add(player1);
         players2.add(player2);
         players2.add(player3);
         team.setPlayers(players2);
         assertEquals(3, team.getPlayers().size());
    }

    @Test
    void getResult() {
        assertEquals("", team.getResult());

    }

    @Test
    void setResult() {
        team.setResult("Win");
        assertEquals("Win", team.getResult());
    }

    @Test
    void getGoals() {
        assertEquals(0, team.getGoals());
    }

    @Test
    void setGoals() {
        team.setGoals(1);
        assertEquals(1, team.getGoals());
    }

    @Test
    void getMatch() {
        assertEquals(1, team.getMatch().getGameNumber());
    }

    @Test
    void setMatch() {
        team.setMatch(match2);
        assertEquals(2, team.getMatch().getGameNumber());
    }
}