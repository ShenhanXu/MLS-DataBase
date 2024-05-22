package com.mls.database.rest.webservices.restfulwebservices.team;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    @Column(name = "name")
    private String name;

    // Constructors
    public Team() {}

    public Team(int team_id, String name) {
        this.team_id = team_id;
        this.name = name;
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
}
