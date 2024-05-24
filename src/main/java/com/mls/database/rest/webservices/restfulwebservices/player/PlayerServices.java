package com.mls.database.rest.webservices.restfulwebservices.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;


@Service
public class PlayerServices {

    private static List<Player> players = new ArrayList<>();
    private static int playersCount = 0;


    // Sample data initialization
    static {
 ;

        players.add(new Player(++playersCount, "Messi", "Forward", 1));
        players.add(new Player(++playersCount, "Marcelo", "Mid", 2));
        players.add(new Player(++playersCount, "Alaba", "Defender", 2));
    }


    public List<Player> findByTeam(int teamId) {
        Predicate<? super Player> predicate = player -> player.getTeam_id() == teamId;
        return players.stream().filter(predicate).collect(Collectors.toList());
    }

    public Player addPlayer(String name, String position, int team_id) {
        Player player = new Player(++playersCount, name, position, team_id);
        players.add(player);
        return player;
    }

    public void deleteById(int id) {
        Predicate<? super Player> predicate = player -> player.getPlayer_id() == id;

        players.removeIf(predicate); // Remove the player

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

    public List<Player> searchByPosition(String position) {
        Predicate<? super Player> predicate = player -> player.getPosition().toLowerCase().contains(position.toLowerCase());
        return players.stream().filter(predicate).collect(Collectors.toList());
    }
}
