package com.mls.database.rest.webservices.restfulwebservices.player;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mls.database.rest.webservices.restfulwebservices.team.TeamRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamRepository teamRepository;



    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        Optional<Player> player = playerService.findById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player playerDetails) {
        Optional<Player> player = playerService.findById(id);
        if (player.isPresent()) {
            playerDetails.setPlayer_id(id);
            Player updatedPlayer = playerService.updatePlayer(playerDetails);
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/team/{team_id}")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable int team_id) {
        Optional<Team> team = teamRepository.findById(team_id);

        if (team.isPresent()) {
            List<Player> players = playerService.findByTeam(team.get());
            return ResponseEntity.ok(players);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

