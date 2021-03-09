package com.codeclan.example.leaderboard_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "games_played")
    private int gamesPlayed;

    @Column(name = "wins")
    private int gamesWon;

    @Column(name = "loses")
    private int gamesLost;

    @Column(name = "draws")
    private int gamesDrawn;

    @Column(name = "points")
    private int points;

    @Column(name = "total_games_played")
    private int totalGamesPlayed;

    @Column(name = "total_wins")
    private int totalGamesWon;

    @Column(name = "total_loses")
    private int totalGamesLost;

    @Column(name = "total_draws")
    private int totalGamesDrawn;

    @Column(name = "total_points")
    private int totalPoints;

    @JsonIgnoreProperties(value = {"players", "matches"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "teams_players",
            joinColumns = {@JoinColumn(name = "player_id" , nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)}
    )
    private List<Team> teams;

    @JsonIgnoreProperties(value = {"players", "matches"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "seasons_players",
            joinColumns = {@JoinColumn(name = "player_id" , nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "season_id", nullable = false, updatable = false)}
    )
    private List<Season> seasons;




    public Player(String name) {
        this.name = name;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.gamesDrawn = 0;
        this.points = 0;
        this.totalGamesPlayed = 0;
        this.totalGamesWon = 0;
        this.totalGamesLost = 0;
        this.totalGamesDrawn = 0;
        this.totalPoints = 0;
        this.teams = new ArrayList<Team>();
        this.seasons = new ArrayList<Season>();

    }
    public Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    public void setTotalGamesWon(int totalGamesWon) {
        this.totalGamesWon = totalGamesWon;
    }

    public int getTotalGamesLost() {
        return totalGamesLost;
    }

    public void setTotalGamesLost(int totalGamesLost) {
        this.totalGamesLost = totalGamesLost;
    }

    public int getTotalGamesDrawn() {
        return totalGamesDrawn;
    }

    public void setTotalGamesDrawn(int totalGamesDrawn) {
        this.totalGamesDrawn = totalGamesDrawn;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
    public void handleResult(String result){
        this.gamesPlayed += 1;
        this.totalGamesPlayed += 1;
        if (result == "win"){
            this.gamesWon += 1;
            this.points += 3;
            this.totalGamesWon += 1;
            this.totalPoints += 3;
        }if (result == "draw"){
            this.gamesDrawn += 1;
            this.points += 1;
            this.totalGamesDrawn += 1;
            this.totalPoints += 1;
        }if (result == "loss"){
            this.gamesLost += 1;
        }
    }
}
