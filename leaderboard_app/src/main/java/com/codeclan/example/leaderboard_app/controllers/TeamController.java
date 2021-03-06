package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Team;
import com.codeclan.example.leaderboard_app.models.Team;
import com.codeclan.example.leaderboard_app.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

        @Autowired
        TeamRepository teamRepository;
        
        @GetMapping(value = "/teams")
    public ResponseEntity<List<Team>> getAllTeams(){
            return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
        }

    @GetMapping(value = "/teams/{id}")
    public ResponseEntity getTeam(@PathVariable Long id){
        return new ResponseEntity<>(teamRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/teams")
    public ResponseEntity<Team> postTeam(@RequestBody Team team){
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @PutMapping(value = "/teams/{id}")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team, @PathVariable Long id) {
        Optional<Team> teamToUpdateOptional = teamRepository.findById(id);
        Team teamToUpdate = teamToUpdateOptional.get();

        teamToUpdate.setName(team.getName());
        teamToUpdate.setPlayers(team.getPlayers());
        teamToUpdate.setResult(team.getResult());
        teamToUpdate.setGoals(team.getGoals());
        teamToUpdate.setMatch(team.getMatch());

        teamRepository.save(teamToUpdate);
        return new ResponseEntity<Team>(team, HttpStatus.OK);
    }

    @DeleteMapping(value = "/teams/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable Long id) {
        Team found = teamRepository.getOne(id);
        teamRepository.delete(found);
        return new ResponseEntity<> (null, HttpStatus.OK);
    }

}
