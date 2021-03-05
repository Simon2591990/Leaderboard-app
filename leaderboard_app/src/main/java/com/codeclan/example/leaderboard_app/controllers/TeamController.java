package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Team;
import com.codeclan.example.leaderboard_app.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

        @Autowired
        TeamRepository teamRepository;

        @GetMapping(value = "/teams")
    public ResponseEntity<List<Team>> getAllTeams(){
            return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
        }

}
