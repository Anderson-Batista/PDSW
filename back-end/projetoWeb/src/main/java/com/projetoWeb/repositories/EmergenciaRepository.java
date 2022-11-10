package com.projetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoWeb.domain.Emergencia;

@Repository
public interface EmergenciaRepository extends JpaRepository<Emergencia, Integer> {

}
