package com.codeclan.example.leaderboard_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_number")
    private int gameNumber;

    @JsonIgnoreProperties(value = "match")
    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private List<Team> teams;

    @JsonIgnoreProperties(value = {"matches", "players"})
    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;


    public Match(int gameNumber, Season season) {
        this.gameNumber = gameNumber;
        this.season = season;
        this.teams = new ArrayList<Team>();
    }
    public Match(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }

    public void addTeam(ArrayList<Team>teams){
        for (Team team : teams){
            this.addTeam(team);
        }
    }

    public void handleResults(int team1Score, int team2Score){
        this.teams.get(0).setGoals(team1Score);
        this.teams.get(1).setGoals(team2Score);
        if (team1Score > team2Score){
            this.teams.get(0).setResult("win");
            this.teams.get(1).setResult("loss");
        }
        if (team1Score < team2Score){
            this.teams.get(0).setResult("loss");
            this.teams.get(1).setResult("win");
        }
        else {
            this.teams.get(0).setResult("draw");
            this.teams.get(1).setResult("draw");

        }
        for (Team team : this.teams){
            for (Player player : team.getPlayers()){
                player.handleResult(team.getResult());
            }
        }



    }
}
