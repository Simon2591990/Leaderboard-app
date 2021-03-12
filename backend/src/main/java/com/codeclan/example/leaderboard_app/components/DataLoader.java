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

        Season season1 = new Season("Season 1",3);
        seasonRepository.save(season1);

        Match match1 = new Match (1,season1);
        matchRepository.save(match1);
        Match match2 = new Match (2,season1);
        matchRepository.save(match2);
        Match match3 = new Match (3,season1);
        matchRepository.save(match3);

        Team team1 = new Team("Old Crabs", match1);

        Team team2 = new Team("Juicy Jellyfish", match1);

        Team team3 = new Team("Fluffy Sharks", match2);
        Team team4 = new Team("Shy Hamsters", match2);

        Team team5 = new Team("Bouncy Goblins", match3);
        Team team6 = new Team("Wonky Badgers", match3);
        team1.setResult("draw");
        team2.setResult("draw");
        team3.setResult("draw");
        team4.setResult("draw");
        team5.setResult("draw");
        team6.setResult("draw");

        Player player1 = new Player("Cristiano Ronaldo");
        Player player2 = new Player("Robert Lewandowski");
        Player player3 = new Player("Lionel Messi");
        Player player4 = new Player("Karim Benzema");
        Player player5 = new Player("Neymar");
        Player player6 = new Player("Kevin De Bruyne");
        Player player7 = new Player("Kylian Mbappe");
        Player player8 = new Player("Thomas Muller");
        Player player9 = new Player("Erling Haaland");
        Player player10 = new Player("Sergio Ramos");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);
        players.add(player9);
        players.add(player10);

        for (Player player : players){
            player.setGamesPlayed(3);
            player.setTotalGamesPlayed(3);
            player.setGamesDrawn(3);
            player.setTotalGamesDrawn(3);
            player.setTotalPoints(3);
            player.setPoints(3);
            playerRepository.save(player);
        }

//        playerRepository.save(player1);
//        playerRepository.save(player2);
//        playerRepository.save(player3);
//        playerRepository.save(player4);
//        playerRepository.save(player5);
//        playerRepository.save(player6);
//        playerRepository.save(player7);
//        playerRepository.save(player8);
//        playerRepository.save(player9);
//        playerRepository.save(player10);

        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.addPlayer(player4);
        team1.addPlayer(player5);
        teamRepository.save(team1);

        team2.addPlayer(player6);
        team2.addPlayer(player7);
        team2.addPlayer(player8);
        team2.addPlayer(player9);
        team2.addPlayer(player10);
        teamRepository.save(team2);

        team3.addPlayer(player1);
        team3.addPlayer(player2);
        team3.addPlayer(player3);
        team3.addPlayer(player4);
        team3.addPlayer(player5);
        teamRepository.save(team3);

        team4.addPlayer(player6);
        team4.addPlayer(player7);
        team4.addPlayer(player8);
        team4.addPlayer(player9);
        team4.addPlayer(player10);
        teamRepository.save(team4);

        team5.addPlayer(player1);
        team5.addPlayer(player2);
        team5.addPlayer(player3);
        team5.addPlayer(player4);
        team5.addPlayer(player5);
        teamRepository.save(team5);

        team6.addPlayer(player6);
        team6.addPlayer(player7);
        team6.addPlayer(player8);
        team6.addPlayer(player9);
        team6.addPlayer(player10);
        teamRepository.save(team6);

        match1.addTeam(team1);
        match1.addTeam(team2);
        matchRepository.save(match1);

        match2.addTeam(team3);
        match2.addTeam(team4);
        matchRepository.save(match2);

        match3.addTeam(team5);
        match3.addTeam(team6);
        matchRepository.save(match3);

        season1.addMatch(match1);
        season1.addMatch(match2);
        season1.addMatch(match3);

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
