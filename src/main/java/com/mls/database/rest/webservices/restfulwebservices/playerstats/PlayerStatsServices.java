package com.mls.database.rest.webservices.restfulwebservices.playerstats;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import com.mls.database.rest.webservices.restfulwebservices.player.Player;

@Service
public class PlayerStatsServices {

    private static List<PlayerStats> playerStatsList = new ArrayList<>();
    private static int statsCount = 0;

    // Sample data initialization
    static {
        // Assuming PlayerServices is initialized and has some players
        Player player1 = new Player(1, "John Doe", "Forward", null);
        Player player2 = new Player(2, "Jane Smith", "Midfielder", null);

        playerStatsList.add(new PlayerStats(++statsCount, player1, 10, 5, 1, 0, 180));
        playerStatsList.add(new PlayerStats(++statsCount, player2, 8, 7, 2, 0, 165));
        playerStatsList.add(new PlayerStats(++statsCount, player1, 15, 10, 3, 1, 190));
    }

    public List<PlayerStats> findByPlayerId(int playerId) {
        Predicate<? super PlayerStats> predicate = stats -> stats.getPlayer().getPlayer_id() == playerId;
        return playerStatsList.stream().filter(predicate).toList();
    }

    public PlayerStats addPlayerStats(Player player, int goals, int assists, int yellow_cards, int red_cards, int height) {
        PlayerStats playerStats = new PlayerStats(++statsCount, player, goals, assists, yellow_cards, red_cards, height);
        playerStatsList.add(playerStats);
        return playerStats;
    }

    public void deleteById(int id) {
        Predicate<? super PlayerStats> predicate = stats -> stats.getStat_id() == id;
        playerStatsList.removeIf(predicate);
    }

    public Optional<PlayerStats> findById(int id) {
        Predicate<? super PlayerStats> predicate = stats -> stats.getStat_id() == id;
        return playerStatsList.stream().filter(predicate).findFirst();
    }

    public void updatePlayerStats(PlayerStats playerStats) {
        deleteById(playerStats.getStat_id());
        playerStatsList.add(playerStats);
    }

    public List<PlayerStats> getAllPlayerStats() {
        return new ArrayList<>(playerStatsList);
    }
}
