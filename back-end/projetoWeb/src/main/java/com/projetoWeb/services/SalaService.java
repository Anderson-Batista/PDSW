package com.projetoWeb.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoWeb.domain.Sala;
import com.projetoWeb.dtos.SalaDTO;
import com.projetoWeb.exceptions.ObjectNotFoundException;
import com.projetoWeb.repositories.SalaRepository;

@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	public Sala findById(Integer id) {
		Optional<Sala> obj = salaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}

	public List<Sala> findAll() {
		return salaRepository.findAll();
	}
	
	public Sala create(SalaDTO objDTO) {
		return salaRepository.save(new Sala(null, objDTO.getNome(), objDTO.getLink(),
				objDTO.getPerimetro(), objDTO.getLongitude(), objDTO.getLatitude(),
				objDTO.getUsuario(), objDTO.getParticipantes()));
	}

	public Sala update(Integer id, @Valid SalaDTO objDTO) {
		Sala oldObj = findById(id);
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setLink(objDTO.getLink());
		oldObj.setPerimetro(objDTO.getPerimetro());
		oldObj.setLongitude(objDTO.getLongitude());
		oldObj.setLatitude(objDTO.getLatitude());
		oldObj.setUsuario(objDTO.getUsuario());
		oldObj.setParticipantes(objDTO.getParticipantes());
		
		return salaRepository.save(oldObj);
	}

	public void delete(Integer id) {
		findById(id);
		salaRepository.deleteById(id);
	}
}
