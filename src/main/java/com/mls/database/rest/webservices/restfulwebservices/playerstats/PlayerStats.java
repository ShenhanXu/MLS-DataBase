package com.mls.database.rest.webservices.restfulwebservices.playerstats;

import jakarta.persistence.*;
import com.mls.database.rest.webservices.restfulwebservices.player.Player;

@Entity
@Table(name = "Player_Stats")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stat_id;

    @OneToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    private int goals;
    private int assists;
    private int yellow_cards;
    private int red_cards;
    private int height;

    // Constructors
    public PlayerStats() {}

    public PlayerStats(int stat_id, Player player, int goals, int assists, int yellow_cards, int red_cards, int height) {
        this.stat_id = stat_id;
        this.player = player;
        this.goals = goals;
        this.assists = assists;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.height = height;
    }

    // Getters and Setters
    public int getStat_id() {
        return stat_id;
    }

    public void setStat_id(int stat_id) {
        this.stat_id = stat_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(int yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public int getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(int red_cards) {
        this.red_cards = red_cards;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
