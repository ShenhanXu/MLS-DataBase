package com.mls.database.rest.webservices.restfulwebservices.player;

import com.mls.database.rest.webservices.restfulwebservices.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByTeam(Team team);
}
