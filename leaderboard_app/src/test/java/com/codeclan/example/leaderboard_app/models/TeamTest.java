package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    Team team;
    Player player1, player2, player3, player4, player5;
    ArrayList<Player> players, players2;


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
        team = new Team("Team1", players);
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
        assertEquals(5, team.getPlayers().size());
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
}