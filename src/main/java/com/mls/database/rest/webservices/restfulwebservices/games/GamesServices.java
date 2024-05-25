package com.mls.database.rest.webservices.restfulwebservices.games;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class GamesServices {

    private static List<Game> games = new ArrayList<>();
    private static int gamesCount = 0;

    // Sample data initialization
    static {
        Team team1 = new Team(1, "Team A");
        Team team2 = new Team(2, "Team B");

        games.add(new Game(++gamesCount, new Date(),  team1, team2, 2, 1));
        games.add(new Game(++gamesCount, new Date(),  team2, team1, 3, 3));
    }

    public List<Game> findByTeam(Team team) {
        Predicate<? super Game> predicate = game -> game.getTeamHome().equals(team) || game.getTeamAway().equals(team);
        return games.stream().filter(predicate).toList();
    }

    public Game addGame(Date date_played, Team teamHome, Team teamAway, int score_home, int score_away) {
        Game game = new Game(++gamesCount, date_played, teamHome, teamAway, score_home, score_away);
        games.add(game);
        return game;
    }

    public void deleteById(int id) {
        Predicate<? super Game> predicate = game -> game.getGame_id() == id;
        games.removeIf(predicate);
    }

    public Optional<Game> findById(int id) {
        Predicate<? super Game> predicate = game -> game.getGame_id() == id;
        return games.stream().filter(predicate).findFirst();
    }

    public void updateGame(Game game) {
        deleteById(game.getGame_id());
        games.add(game);
    }

    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }
}
