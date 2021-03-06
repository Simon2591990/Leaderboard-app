package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Player;
import com.codeclan.example.leaderboard_app.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping(value = "/players")
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(playerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/players/{id}")
    public ResponseEntity getPlayer(@PathVariable Long id){
        return new ResponseEntity<>(playerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/players")
    public ResponseEntity<Player> postPlayer(@RequestBody Player player){
        playerRepository.save(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping(value = "/players/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player, @PathVariable Long id) {
        Optional<Player> playerToUpdateOptional = playerRepository.findById(id);
        Player playerToUpdate = playerToUpdateOptional.get();

        playerToUpdate.setName(player.getName());
        playerToUpdate.setGamesPlayed(player.getGamesPlayed());
        playerToUpdate.setGamesWon(player.getGamesWon());
        playerToUpdate.setGamesDrawn(player.getGamesDrawn());
        playerToUpdate.setGamesLost(player.getGamesLost());
        playerToUpdate.setPoints(player.getPoints());
        playerToUpdate.setTeams(player.getTeams());

        playerRepository.save(playerToUpdate);
        return new ResponseEntity<Player>(playerToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/players/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable Long id) {
        Player found = playerRepository.getOne(id);
        playerRepository.delete(found);
        return new ResponseEntity<> (null, HttpStatus.OK);
    }


}
