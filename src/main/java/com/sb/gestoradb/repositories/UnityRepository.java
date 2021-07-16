package com.sb.gestoradb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.gestoradb.domain.Unity;

// TODO study Repository
@Repository
public interface UnityRepository extends JpaRepository<Unity, Integer>{

}
