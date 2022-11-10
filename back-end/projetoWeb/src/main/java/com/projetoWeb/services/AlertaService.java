package com.projetoWeb.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoWeb.domain.Alerta;
import com.projetoWeb.dtos.AlertaDTO;
import com.projetoWeb.exceptions.ObjectNotFoundException;
import com.projetoWeb.repositories.AlertaRepository;

@Service
public class AlertaService {

	@Autowired
	private AlertaRepository alertaRepo;

	public Alerta create(AlertaDTO a) {
		return alertaRepo.save(new Alerta(null, a.getIdUsuario(), a.getIdSala(), a.getLatitude(), a.getLatitude(),
				a.getHora(), a.getServicosEmergencia()));
	}

	public Alerta findById(Integer id) {
		Optional<Alerta> alerta = alertaRepo.findById(id);
		return alerta.orElseThrow(() -> new ObjectNotFoundException("Alerta[id=" + id + "] não encontrado."));
	}

	public List<Alerta> findAll() {
		return alertaRepo.findAll();
	}

	public Alerta update(Integer id, @Valid AlertaDTO aDTO) {
		Alerta old = findById(id);
		old.setIdUsuario(aDTO.getIdUsuario());
		old.setIdSala(aDTO.getIdSala());
		old.setLatitude(aDTO.getLatitude());
		old.setLongitude(aDTO.getLongitude());
		old.setHora(aDTO.getHora());
		old.setServicosEmergencia(aDTO.getServicosEmergencia());
		return alertaRepo.save(old);
	}

	public void delete(Integer id) {
		findById(id);
		alertaRepo.deleteById(id);
	}
}
