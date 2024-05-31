package com.mls.database.rest.webservices.restfulwebservices.team;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mls.database.rest.webservices.restfulwebservices.player.Player;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private int points;


    // Constructors
    public Team() {}

    public Team(int team_id, String name, int points) {
        this.team_id = team_id;
        this.name = name;
        this.points = points;
    }

    // Getters and Setters
    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
