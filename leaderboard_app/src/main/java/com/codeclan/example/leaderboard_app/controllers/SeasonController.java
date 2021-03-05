package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Season;
import com.codeclan.example.leaderboard_app.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeasonController {
    @Autowired
    SeasonRepository seasonRepository;

    @GetMapping(value = "/seasons")
    public ResponseEntity<List<Season>> getAllSeasons(){
        return new ResponseEntity<>(seasonRepository.findAll(), HttpStatus.OK);
    }

}
