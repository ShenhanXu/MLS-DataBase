package com.mls.database.rest.webservices.restfulwebservices.team;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class TeamServices {

    private static List<Team> teams = new ArrayList<>();
    private static int teamsCount = 0;

    // Sample data initialization
    static {
        teams.add(new Team(++teamsCount, "FCB"));
        teams.add(new Team(++teamsCount, "RMD"));
    }

    public List<Team> getAllTeams() {
        return new ArrayList<>(teams);
    }

    public Optional<Team> findById(int id) {
        Predicate<? super Team> predicate = team -> team.getTeam_id() == id;
        return teams.stream().filter(predicate).findFirst();
    }

    public Team addTeam(String name) {
        Team team = new Team(++teamsCount, name);
        teams.add(team);
        return team;
    }

    public void deleteById(int id) {
        Predicate<? super Team> predicate = team -> team.getTeam_id() == id;
        teams.removeIf(predicate);
    }

    public void updateTeam(Team team) {
        deleteById(team.getTeam_id());
        teams.add(team);
    }
}
