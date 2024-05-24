package com.mls.database.rest.webservices.restfulwebservices.playerstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playerstats")
public class PlayerStatsController {

    @Autowired
    private PlayerStatsServices playerStatsServices;

    @GetMapping("")
    public List<PlayerStats> getAllPlayerStats() {
        return playerStatsServices.getAllPlayerStats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerStats> getPlayerStatsById(@PathVariable int id) {
        Optional<PlayerStats> playerStats = playerStatsServices.findById(id);
        return playerStats.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public PlayerStats createPlayerStats(@RequestBody PlayerStats playerStats) {
        return playerStatsServices.addPlayerStats(playerStats.getPlayer(), playerStats.getGoals(), playerStats.getAssists(), playerStats.getYellow_cards(), playerStats.getRed_cards(), playerStats.getHeight());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerStats> updatePlayerStats(@PathVariable int id, @RequestBody PlayerStats playerStatsDetails) {
        Optional<PlayerStats> existingPlayerStats = playerStatsServices.findById(id);
        if (existingPlayerStats.isPresent()) {
            PlayerStats playerStats = existingPlayerStats.get();
            playerStats.setPlayer(playerStatsDetails.getPlayer());
            playerStats.setGoals(playerStatsDetails.getGoals());
            playerStats.setAssists(playerStatsDetails.getAssists());
            playerStats.setYellow_cards(playerStatsDetails.getYellow_cards());
            playerStats.setRed_cards(playerStatsDetails.getRed_cards());
            playerStats.setHeight(playerStatsDetails.getHeight());
            playerStatsServices.updatePlayerStats(playerStats);
            return ResponseEntity.ok(playerStats);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerStats(@PathVariable int id) {
        playerStatsServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
