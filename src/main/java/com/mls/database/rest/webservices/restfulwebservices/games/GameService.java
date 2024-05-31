package com.mls.database.rest.webservices.restfulwebservices.games;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;
import com.mls.database.rest.webservices.restfulwebservices.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> findById(int id) {
        return gameRepository.findById(id);
    }


    @Transactional
    public Game addGame(Game game) {
        // Fetch the team entities from the database
        Team homeTeam = teamRepository.findById(game.getTeamHome().getTeam_id())
                .orElseThrow(() -> new RuntimeException("Home team not found"));
        Team awayTeam = teamRepository.findById(game.getTeamAway().getTeam_id())
                .orElseThrow(() -> new RuntimeException("Away team not found"));

        // Set the fetched teams to the game
        game.setTeamHome(homeTeam);
        game.setTeamAway(awayTeam);

        // Save the game
        Game savedGame = gameRepository.save(game);

        // Update team points based on the result
        if (game.getScore_home() > game.getScore_away()) {
            homeTeam.setPoints(homeTeam.getPoints() + 3);
        } else if (game.getScore_home() < game.getScore_away()) {
            awayTeam.setPoints(awayTeam.getPoints() + 3);
        } else {
            homeTeam.setPoints(homeTeam.getPoints() + 1);
            awayTeam.setPoints(awayTeam.getPoints() + 1);
        }

        teamRepository.save(homeTeam);
        teamRepository.save(awayTeam);

        return savedGame;
    }
    public Game updateGame(Game gameDetails) {
        return gameRepository.save(gameDetails);
    }

    public void deleteById(int id) {
        gameRepository.deleteById(id);
    }
}
