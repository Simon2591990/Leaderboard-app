package com.codeclan.example.leaderboard_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @JsonIgnoreProperties(value = "season")
    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
    private List<Match> matches;

    public Season(String name, int totalMatches) {
        this.name = name;
        this.totalMatches = totalMatches;
        this.matches = new ArrayList<Match>();
    }

    public Season(){

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

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    public void addMatch(Match match){
        this.matches.add(match);
    }
}

