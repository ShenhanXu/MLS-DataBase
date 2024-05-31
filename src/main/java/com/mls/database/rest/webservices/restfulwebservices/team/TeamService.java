package com.mls.database.rest.webservices.restfulwebservices.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> findById(int id) {
        return teamRepository.findById(id);
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById(int id) {
        teamRepository.deleteById(id);
    }


}
