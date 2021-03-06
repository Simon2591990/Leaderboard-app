package com.codeclan.example.leaderboard_app.repositories;

import com.codeclan.example.leaderboard_app.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
