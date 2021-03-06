package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.*;
import com.codeclan.example.leaderboard_app.repositories.MatchRepository;
import com.codeclan.example.leaderboard_app.repositories.PlayerRepository;
import com.codeclan.example.leaderboard_app.repositories.SeasonRepository;
import com.codeclan.example.leaderboard_app.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SeasonController {
    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PlayerRepository playerRepository;

    TeamNameGenerator teamNameGenerator = new TeamNameGenerator();

    @GetMapping(value = "/seasons")
    public ResponseEntity<List<Season>> getAllSeasons(){
        return new ResponseEntity<>(seasonRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/seasons/{id}")
    public ResponseEntity getSeasons(@PathVariable Long id){
        return new ResponseEntity<>(seasonRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/seasons")
    public ResponseEntity<Season> postSeasons(@RequestBody Season season){
        List<Player> players = season.getPlayers();
        for (Player player : players){
            player.resetSeasonResults();
            playerRepository.save(player);
        }

        seasonRepository.save(season);
        return new ResponseEntity<>(season, HttpStatus.CREATED);
    }

    @PutMapping(value = "/seasons/{id}")
    public ResponseEntity<Season> updateSeason(@RequestBody Season season, @PathVariable Long id) {
        Optional<Season> seasonToUpdateOptional = seasonRepository.findById(id);
        Season seasonToUpdate = seasonToUpdateOptional.get();

        seasonToUpdate.setName(season.getName());
        seasonToUpdate.setMatches(season.getMatches());
        seasonToUpdate.setTotalMatches(season.getTotalMatches());
        seasonToUpdate.setPlayers(season.getPlayers());
        seasonToUpdate.setCompleted((season.isCompleted()));

        seasonRepository.save(seasonToUpdate);
        return new ResponseEntity<Season>(seasonToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/seasons/{id}")
    public ResponseEntity<Season> deleteSeason(@PathVariable Long id) {
        Season found = seasonRepository.getOne(id);
        seasonRepository.delete(found);
        return new ResponseEntity<> (null, HttpStatus.OK);
    }

    @GetMapping (value = "/seasons/{id}/new_match")
    public ResponseEntity<Match> createMatch(@PathVariable Long id){
        Season seasonFound = seasonRepository.findById(id).get();
        int newMatchNumber = seasonFound.getMatches().size() + 1;
        Match match = new Match(newMatchNumber,seasonFound);
        matchRepository.save(match);
        List<Player> players = seasonFound.getPlayers();

        Collections.shuffle(players);
        List<Player> team1Players = players.subList(0,5);
        List<Player> team2Players = players.subList(5,10);
        String team1Name = teamNameGenerator.generateName();
        String team2Name = teamNameGenerator.generateName();
        Team team1 = new Team (team1Name,match);
        Team team2 = new Team (team2Name,match);
        team1.setPlayers(team1Players);
        team2.setPlayers(team2Players);
        teamRepository.save(team1);
        teamRepository.save(team2);
        match.addTeam(team1);
        match.addTeam(team2);
        matchRepository.save(match);

        return new ResponseEntity<>(match, HttpStatus.OK);
    }

}
