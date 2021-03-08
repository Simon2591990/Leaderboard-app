package com.codeclan.example.leaderboard_app.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamNameGeneratorTest {

    TeamNameGenerator teamNameGenerator;

    @BeforeEach
    void setUp() {
         teamNameGenerator = new TeamNameGenerator();
    }

    @Test
    void has100Adjectives() {
        assertEquals(100, teamNameGenerator.getAdjectives().size());
    }

}