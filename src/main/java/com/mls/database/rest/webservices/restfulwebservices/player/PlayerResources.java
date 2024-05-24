package com.mls.database.rest.webservices.restfulwebservices.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")

public class PlayerResources {

    private final PlayerServices playerServices;

    @Autowired
    public PlayerResources(PlayerServices playerServices) {
        this.playerServices = playerServices;
    }

    // Retrieve all players
    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerServices.getAllPlayers();
    }

    // Retrieve a single player by ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> retrievePlayer(@PathVariable int id) {
        Optional<Player> player = playerServices.findById(id);
        return player.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new player
    @PostMapping("")
    public Player createPlayer(@RequestBody Player player) {
        return playerServices.addPlayer(player.getName(), player.getPosition(), player.getTeam_id());
    }

    // Update an existing player
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player playerDetails) {
        playerDetails.setPlayer_id(id);
        playerServices.updatePlayer(playerDetails);
        return playerDetails;
    }

    // Delete a player
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        playerServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Search players by team
    @GetMapping("/team/{team}")
    public List<Player> searchPlayersByTeam(@PathVariable int team) {
        return playerServices.findByTeam(team);
    }

    // Search players by position
    @GetMapping("/position/{position}")
    public List<Player> searchPlayersByPosition(@PathVariable String position) {
        return playerServices.searchByPosition(position);
    }
}
