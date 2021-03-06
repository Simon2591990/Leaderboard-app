package com.codeclan.example.leaderboard_app.repositories;

import com.codeclan.example.leaderboard_app.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository  extends JpaRepository<Match, Long> {
}
