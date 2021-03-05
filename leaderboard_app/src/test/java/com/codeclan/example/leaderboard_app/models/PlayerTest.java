package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Player McPlayerFace");

    }

    @Test
    void getName() {
        assertEquals("Player McPlayerFace", player.getName());
    }

    @Test
    void setName() {
        player.setName("Player2");
        assertEquals("Player2", player.getName());

    }

    @Test
    void getGamesPlayed() {
        assertEquals(0, player.getGamesPlayed());
    }

    @Test
    void setGamesPlayed() {
        player.setGamesPlayed(1);
        assertEquals(1, player.getGamesPlayed());
    }

    @Test
    void getGamesWon() {
        assertEquals(0, player.getGamesWon());
    }

    @Test
    void setGamesWon() {
        player.setGamesWon(1);
        assertEquals(1, player.getGamesWon());
    }

    @Test
    void getGamesLost() {
        assertEquals(0, player.getGamesLost());
    }

    @Test
    void setGamesLost() {
        player.setGamesLost(1);
        assertEquals(1, player.getGamesLost());
    }

    @Test
    void getGamesDrawn() {
        assertEquals(0, player.getGamesDrawn());
    }

    @Test
    void setGamesDrawn() {
        player.setGamesDrawn(1);
        assertEquals(1, player.getGamesDrawn());
    }

    @Test
    void getPoints() {
        assertEquals(0, player.getPoints());
    }

    @Test
    void setPoints() {
        player.setPoints(1);
        assertEquals(1, player.getPoints());
    }


}