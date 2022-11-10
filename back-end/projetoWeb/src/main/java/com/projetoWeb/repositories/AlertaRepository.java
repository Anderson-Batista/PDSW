package com.projetoWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoWeb.domain.Alerta;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Integer> {

}
