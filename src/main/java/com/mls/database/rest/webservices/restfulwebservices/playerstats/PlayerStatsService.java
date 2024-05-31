package com.mls.database.rest.webservices.restfulwebservices.playerstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerStatsService {

    private final PlayerStatsRepository playerStatsRepository;

    @Autowired
    public PlayerStatsService(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    public List<PlayerStats> getAllPlayerStats() {
        return playerStatsRepository.findAll();
    }

    public Optional<PlayerStats> findById(int playerId) {
        return playerStatsRepository.findById(playerId);
    }

    public PlayerStats addPlayerStats(PlayerStats playerStats) {
        return playerStatsRepository.save(playerStats);
    }

    public PlayerStats updatePlayerStats(PlayerStats playerStatsDetails) {
        return playerStatsRepository.save(playerStatsDetails);
    }

    public void deleteById(int playerId) {
        playerStatsRepository.deleteById(playerId);
    }
}
