package com.mls.database.rest.webservices.restfulwebservices.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GamesServices gamesServices;

    @GetMapping("")
    public List<Game> getAllGames() {
        return gamesServices.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable int id) {
        Optional<Game> game = gamesServices.findById(id);
        return game.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Game createGame(@RequestBody Game game) {
        return gamesServices.addGame(
                game.getDate_played(),
                game.getPlace(),
                game.getTeamHome(),
                game.getTeamAway(),
                game.getScore_home(),
                game.getScore_away()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable int id, @RequestBody Game gameDetails) {
        Optional<Game> existingGame = gamesServices.findById(id);
        if (existingGame.isPresent()) {
            Game game = existingGame.get();
            game.setDate_played(gameDetails.getDate_played());
            game.setPlace(gameDetails.getPlace());
            game.setTeamHome(gameDetails.getTeamHome());
            game.setTeamAway(gameDetails.getTeamAway());
            game.setScore_home(gameDetails.getScore_home());
            game.setScore_away(gameDetails.getScore_away());
            gamesServices.updateGame(game);
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable int id) {
        gamesServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
