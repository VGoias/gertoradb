package com.sb.gestoradb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.gestoradb.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
