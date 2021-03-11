package com.codeclan.example.leaderboard_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_matches")
    private int totalMatches;

    @Column(name = "completed")
    private boolean completed;

    @JsonIgnoreProperties(value = "season")
    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
    private List<Match> matches;

    @JsonIgnoreProperties(value = {"seasons", "teams"})
//    @JsonIgnoreProperties(value = "teams")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "season_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "player_id", nullable = false, updatable = false)}
    )
    private List<Player> players;


    public Season(String name, int totalMatches) {
        this.name = name;
        this.totalMatches = totalMatches;
        this.matches = new ArrayList<Match>();
        this.players = new ArrayList<Player>();
        this.completed = false;
    }

    public Season(){

    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    public void addMatch(Match match){
        this.matches.add(match);
    }

}

