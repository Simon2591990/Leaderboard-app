package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Match;
import com.codeclan.example.leaderboard_app.models.Player;
import com.codeclan.example.leaderboard_app.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatchController {

    @Autowired
    MatchRepository matchRepository;

    @GetMapping(value = "/matches")
    public ResponseEntity<List<Match>> getAllMatches() {
        return new ResponseEntity<>(matchRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/matches/{id}")
    public ResponseEntity getMatches(@PathVariable Long id){
        return new ResponseEntity<>(matchRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/matches")
    public ResponseEntity<Match> postMatch(@RequestBody Match match){
        matchRepository.save(match);
        return new ResponseEntity<>(match, HttpStatus.CREATED);
    }

    @PutMapping(value = "/matches/{id}")
    public ResponseEntity<Match> updateMatch(@RequestBody Match match, @PathVariable Long id) {
        Optional<Match> matchToUpdateOptional = matchRepository.findById(id);
        Match matchToUpdate = matchToUpdateOptional.get();

        matchToUpdate.setGameNumber(match.getGameNumber());
        matchToUpdate.setTeams(match.getTeams());
        matchToUpdate.setSeason(match.getSeason());
        matchRepository.save(matchToUpdate);
        return new ResponseEntity<Match>(matchToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/matches/{id}")
    public ResponseEntity<Match> deleteMatch(@PathVariable Long id) {
        Match found = matchRepository.getOne(id);
        matchRepository.delete(found);
        return new ResponseEntity<> (null, HttpStatus.OK);
    }

    @PutMapping(value = "/matches/{id}/{team1Score}/{team2Score}")
    public ResponseEntity<Match> updateResults(@PathVariable Long id, @PathVariable Integer team1Score, @PathVariable Integer team2Score){
        Optional<Match> matchToUpdateOptional = matchRepository.findById(id);
        Match matchToUpdate = matchToUpdateOptional.get();

        matchToUpdate.handleResults(team1Score, team2Score);
        matchRepository.save(matchToUpdate);

        return new ResponseEntity<>(matchToUpdate, HttpStatus.OK);
    }
}
