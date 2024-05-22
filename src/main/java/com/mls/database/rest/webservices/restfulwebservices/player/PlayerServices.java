package com.mls.database.rest.webservices.restfulwebservices.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


import org.springframework.stereotype.Service;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;


@Service
public class PlayerServices {

    private static List<Player> players = new ArrayList<>();
    private static int playersCount = 0;



    // Sample data initialization
    static {
        Team team1 = new Team();
        team1.setTeam_id(1);
        team1.setName("Team A");

        Team team2 = new Team();
        team2.setTeam_id(2);
        team2.setName("Team B");

        players.add(new Player(++playersCount, "John Doe", "Forward", team1));
        players.add(new Player(++playersCount, "Jane Smith", "Midfielder", team2));
        players.add(new Player(++playersCount, "Mike Johnson", "Defender", team1));
    }

    public List<Player> findByTeam(Team team) {
        Predicate<? super Player> predicate = player -> player.getTeam().equals(team);
        return players.stream().filter(predicate).toList();
    }

    public Player addPlayer(String name, String position, Team team) {
        Player player = new Player(++playersCount, name, position, team);
        players.add(player);
        return player;
    }

    public void deleteById(int id) {
        Predicate<? super Player> predicate = player -> player.getPlayer_id() == id;
        players.removeIf(predicate);
    }

    public Optional<Player> findById(int id) {
        Predicate<? super Player> predicate = player -> player.getPlayer_id() == id;
        return players.stream().filter(predicate).findFirst();
    }

    public void updatePlayer(Player player) {
        deleteById(player.getPlayer_id());
        players.add(player);
    }

    public List<Player> getAllPlayers() {
        return new ArrayList<>(players);
    }
}
