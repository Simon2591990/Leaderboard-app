package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Match;
import com.codeclan.example.leaderboard_app.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    MatchRepository matchRepository;

    @GetMapping(value = "/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return new ResponseEntity<>(matchRepository.findAll(), HttpStatus.OK);
    }
}
