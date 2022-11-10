package com.projetoWeb.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoWeb.domain.Emergencia;
import com.projetoWeb.dtos.EmergenciaDTO;
import com.projetoWeb.exceptions.ObjectNotFoundException;
import com.projetoWeb.repositories.EmergenciaRepository;

@Service
public class EmergenciaService {

	@Autowired
	private EmergenciaRepository emergenciaRepo;

	public Emergencia findById(Integer id) {
		Optional<Emergencia> e = emergenciaRepo.findById(id);
		return e.orElseThrow(() -> new ObjectNotFoundException("Emergencia[id=" + id + "] não encontrado."));
	}

	public List<Emergencia> findAll() {
		return emergenciaRepo.findAll();
	}

	public Emergencia create(EmergenciaDTO eDTO) {
		return emergenciaRepo.save(new Emergencia(null, eDTO.getServico(), eDTO.getTelefone()));
	}

	public Emergencia update(Integer id, @Valid EmergenciaDTO eDTO) {
		Emergencia old = findById(id);
		old.setServico(eDTO.getServico());
		old.setTelefone(eDTO.getTelefone());
		return emergenciaRepo.save(old);
	}

	public void delete(Integer id) {
		findById(id);
		emergenciaRepo.deleteById(id);
	}
}
