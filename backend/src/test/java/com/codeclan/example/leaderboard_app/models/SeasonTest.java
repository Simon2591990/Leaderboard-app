package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SeasonTest {

    Season season;

    @BeforeEach
    void setUp() {
        season = new Season("Season 1",10);
    }

    @Test
    void getName() {
        assertEquals("Season 1", season.getName());
    }

    @Test
    void setName() {
        season.setName("Season 2");
        assertEquals("Season 2", season.getName());
    }

    @Test
    void getTotalMatches() {
        assertEquals(10, season.getTotalMatches());
    }

    @Test
    void setTotalMatches() {
        season.setTotalMatches(12);
        assertEquals(12, season.getTotalMatches());
    }

    @Test
    void getMatches() {
        assertEquals(0, season.getMatches().size());
    }


}