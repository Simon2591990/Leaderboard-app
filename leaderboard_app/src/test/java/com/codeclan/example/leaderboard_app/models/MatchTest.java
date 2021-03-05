package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    Team team1, team2;
    Player player1, player2, player3, player4, player5;
    ArrayList<Player> players, players2;
    Match match;
    ArrayList<Team> teams;


    @BeforeEach
    void setUp() {
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        player3 = new Player("Player3");
        player4 = new Player("Player4");
        player5 = new Player("Player5");
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        team1 = new Team("Team1", players);
        team2 = new Team("Team2", players);
        teams = new ArrayList<Team>();
        teams.add(team1);
        teams.add(team2);

        match = new Match(1,teams);
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
        assertEquals(2, match.getTeams().size());
    }

    @Test
    void setTeams() {
        teams.add(team1);
        match.setTeams(teams);
        assertEquals(3, match.getTeams().size());

    }
}