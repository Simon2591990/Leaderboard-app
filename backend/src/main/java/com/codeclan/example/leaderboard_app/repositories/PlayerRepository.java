package com.codeclan.example.leaderboard_app.repositories;

import com.codeclan.example.leaderboard_app.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
