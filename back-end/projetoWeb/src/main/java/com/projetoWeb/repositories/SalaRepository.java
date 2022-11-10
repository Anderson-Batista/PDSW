package com.projetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoWeb.domain.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}
