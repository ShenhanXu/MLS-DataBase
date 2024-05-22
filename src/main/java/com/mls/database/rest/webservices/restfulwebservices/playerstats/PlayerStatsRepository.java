package com.mls.database.rest.webservices.restfulwebservices.playerstats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Integer> {
}
