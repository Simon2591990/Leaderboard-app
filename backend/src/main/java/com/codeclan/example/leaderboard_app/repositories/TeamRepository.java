package com.codeclan.example.leaderboard_app.repositories;

import com.codeclan.example.leaderboard_app.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository <Team, Long> {
}
