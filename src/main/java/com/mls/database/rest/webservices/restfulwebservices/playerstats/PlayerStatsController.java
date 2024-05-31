package com.mls.database.rest.webservices.restfulwebservices.playerstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playerstats")
public class PlayerStatsController {

    private final PlayerStatsService playerStatsService;

    @Autowired
    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @GetMapping
    public List<PlayerStats> getAllPlayerStats() {
        return playerStatsService.getAllPlayerStats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerStats> getPlayerStatsById(@PathVariable int id) {
        Optional<PlayerStats> playerStats = playerStatsService.findById(id);
        return playerStats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlayerStats> addPlayerStats(@RequestBody PlayerStats playerStats) {
        PlayerStats createdPlayerStats = playerStatsService.addPlayerStats(playerStats);
        return ResponseEntity.ok(createdPlayerStats);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerStats> updatePlayerStats(@PathVariable int id, @RequestBody PlayerStats playerStatsDetails) {
        Optional<PlayerStats> playerStats = playerStatsService.findById(id);
        if (playerStats.isPresent()) {
            playerStatsDetails.setPlayer_id(id);
            PlayerStats updatedPlayerStats = playerStatsService.updatePlayerStats(playerStatsDetails);
            return ResponseEntity.ok(updatedPlayerStats);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerStats(@PathVariable int id) {
        Optional<PlayerStats> playerStats = playerStatsService.findById(id);
        if (playerStats.isPresent()) {
            playerStatsService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
