package com.mls.database.rest.webservices.restfulwebservices.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamServices.getAllTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable int id) {
        Optional<Team> team = teamServices.findById(id);
        return team.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Team createTeam(@RequestBody Team team) {
        return teamServices.addTeam(team.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable int id, @RequestBody Team teamDetails) {
        Optional<Team> existingTeam = teamServices.findById(id);
        if (existingTeam.isPresent()) {
            Team team = existingTeam.get();
            team.setName(teamDetails.getName());
            teamServices.updateTeam(team);
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        teamServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
