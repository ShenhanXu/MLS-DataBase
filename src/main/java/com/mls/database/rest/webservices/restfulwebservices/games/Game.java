package com.mls.database.rest.webservices.restfulwebservices.games;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int game_id;

    @Temporal(TemporalType.DATE)
    private Date date_played;

    private String place;

    @ManyToOne
    @JoinColumn(name = "team_home_id", nullable = false)
    private Team teamHome;

    @ManyToOne
    @JoinColumn(name = "team_away_id", nullable = false)
    private Team teamAway;

    private int score_home;
    private int score_away;

    // Constructors
    public Game() {}

    public Game(int game_id, Date date_played, String place, Team teamHome, Team teamAway, int score_home, int score_away) {
        this.game_id = game_id;
        this.date_played = date_played;
        this.place = place;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.score_home = score_home;
        this.score_away = score_away;
    }

    // Getters and Setters
    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public Date getDate_played() {
        return date_played;
    }

    public void setDate_played(Date date_played) {
        this.date_played = date_played;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }

    public int getScore_home() {
        return score_home;
    }

    public void setScore_home(int score_home) {
        this.score_home = score_home;
    }

    public int getScore_away() {
        return score_away;
    }

    public void setScore_away(int score_away) {
        this.score_away = score_away;
    }
}
