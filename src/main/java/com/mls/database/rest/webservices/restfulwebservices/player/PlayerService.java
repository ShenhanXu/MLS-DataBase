package com.mls.database.rest.webservices.restfulwebservices.player;

import com.mls.database.rest.webservices.restfulwebservices.playerstats.PlayerStats;
import com.mls.database.rest.webservices.restfulwebservices.playerstats.PlayerStatsRepository;
import com.mls.database.rest.webservices.restfulwebservices.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerStatsRepository playerStatsRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(int id) {
        return playerRepository.findById(id);
    }

    public Player addPlayer(Player player) {
        Player savedPlayer = playerRepository.save(player);

        return savedPlayer;
    }

    public Player updatePlayer(Player playerDetails) {
        return playerRepository.save(playerDetails);
    }

    public void deleteById(int id) {
        // First, delete the stats associated with the player
        playerStatsRepository.deleteById(id);
        // Then, delete the player
        playerRepository.deleteById(id);
    }

    public List<Player> findByTeam(Team team) {
        return playerRepository.findByTeam(team);
    }
}
