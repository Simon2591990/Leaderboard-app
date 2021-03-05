package com.codeclan.example.leaderboard_app.components;

import com.codeclan.example.leaderboard_app.models.Match;
import com.codeclan.example.leaderboard_app.models.Player;
import com.codeclan.example.leaderboard_app.models.Season;
import com.codeclan.example.leaderboard_app.models.Team;
import com.codeclan.example.leaderboard_app.repositories.MatchRepository;
import com.codeclan.example.leaderboard_app.repositories.PlayerRepository;
import com.codeclan.example.leaderboard_app.repositories.SeasonRepository;
import com.codeclan.example.leaderboard_app.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PlayerRepository playerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args)  {

        Season season1 = new Season("Season 1",10);
        seasonRepository.save(season1);

        Match match1 = new Match (1,season1);
        matchRepository.save(match1);

        Team team1 = new Team("Team 1", match1);
        teamRepository.save(team1);

        Player player1 = new Player("Player 1");
        playerRepository.save(player1);

    }
}
