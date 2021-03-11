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

import java.util.ArrayList;

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

//        Match match1 = new Match (1,season1);
//        matchRepository.save(match1);
//        Match match2 = new Match (2,season1);
//        matchRepository.save(match2);
//        Match match3 = new Match (3,season1);
//        matchRepository.save(match3);

//        Team team1 = new Team("Team 1", match1);
//        Team team2 = new Team("Team 2", match1);
//
//        Team team3 = new Team("Team 3", match2);
//        Team team4 = new Team("Team 4", match2);
//
//        Team team5 = new Team("Team 5", match3);
//        Team team6 = new Team("Team 6", match3);

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");
        Player player6 = new Player("Player 6");
        Player player7 = new Player("Player 7");
        Player player8 = new Player("Player 8");
        Player player9 = new Player("Player 9");
        Player player10 = new Player("Player 10");
        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);
        playerRepository.save(player6);
        playerRepository.save(player7);
        playerRepository.save(player8);
        playerRepository.save(player9);
        playerRepository.save(player10);

//        team1.addPlayer(player1);
//        team1.addPlayer(player2);
//        team1.addPlayer(player3);
//        team1.addPlayer(player4);
//        team1.addPlayer(player5);
//        teamRepository.save(team1);
//
//        team2.addPlayer(player6);
//        team2.addPlayer(player7);
//        team2.addPlayer(player8);
//        team2.addPlayer(player9);
//        team2.addPlayer(player10);
//        teamRepository.save(team2);
//
//        team3.addPlayer(player1);
//        team3.addPlayer(player2);
//        team3.addPlayer(player3);
//        team3.addPlayer(player4);
//        team3.addPlayer(player5);
//        teamRepository.save(team3);
//
//        team4.addPlayer(player6);
//        team4.addPlayer(player7);
//        team4.addPlayer(player8);
//        team4.addPlayer(player9);
//        team4.addPlayer(player10);
//        teamRepository.save(team4);
//
//        team5.addPlayer(player1);
//        team5.addPlayer(player2);
//        team5.addPlayer(player3);
//        team5.addPlayer(player4);
//        team5.addPlayer(player5);
//        teamRepository.save(team5);
//
//        team6.addPlayer(player6);
//        team6.addPlayer(player7);
//        team6.addPlayer(player8);
//        team6.addPlayer(player9);
//        team6.addPlayer(player10);
//        teamRepository.save(team6);

//        match1.addTeam(team1);
//        match1.addTeam(team2);
//        matchRepository.save(match1);
//
//        match2.addTeam(team3);
//        match2.addTeam(team4);
//        matchRepository.save(match2);
//
//        match3.addTeam(team5);
//        match3.addTeam(team6);
//        matchRepository.save(match3);

//        season1.addMatch(match1);
//        season1.addMatch(match2);
//        season1.addMatch(match3);
        season1.addPlayer(player1);
        season1.addPlayer(player2);
        season1.addPlayer(player3);
        season1.addPlayer(player4);
        season1.addPlayer(player5);
        season1.addPlayer(player6);
        season1.addPlayer(player7);
        season1.addPlayer(player8);
        season1.addPlayer(player9);
        season1.addPlayer(player10);
        seasonRepository.save(season1);


    }
}
