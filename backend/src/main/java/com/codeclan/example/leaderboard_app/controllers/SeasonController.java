package com.codeclan.example.leaderboard_app.controllers;

import com.codeclan.example.leaderboard_app.models.Player;
import com.codeclan.example.leaderboard_app.models.Season;
import com.codeclan.example.leaderboard_app.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SeasonController {
    @Autowired
    SeasonRepository seasonRepository;

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

        seasonRepository.save(seasonToUpdate);
        return new ResponseEntity<Season>(seasonToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/seasons/{id}")
    public ResponseEntity<Season> deleteSeason(@PathVariable Long id) {
        Season found = seasonRepository.getOne(id);
        seasonRepository.delete(found);
        return new ResponseEntity<> (null, HttpStatus.OK);
    }

}
