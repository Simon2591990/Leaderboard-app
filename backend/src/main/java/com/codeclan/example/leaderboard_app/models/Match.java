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

    @JsonIgnoreProperties(value = "matches")
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
}
