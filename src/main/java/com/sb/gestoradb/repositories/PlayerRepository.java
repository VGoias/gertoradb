package com.sb.gestoradb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sb.gestoradb.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

	// TODO study JPQL
	@Query("SELECT obj FROM Player obj WHERE obj.unity.id = :id_unity ORDER BY obj.nick")
	List<Player> findAllByUnity(@Param(value = "id_unity") Integer id_unity);

}
