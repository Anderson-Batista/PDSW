package com.projetoWeb.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoWeb.domain.Sala;
import com.projetoWeb.domain.Usuario;
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
				objDTO.getUsuario(), objDTO.getParticipantes(), objDTO.getNotificacaoPersistente()));
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
		oldObj.setSalaIniciada(objDTO.getSalaIniciada());
		
		return salaRepository.save(oldObj);
	}

	public void delete(Integer id) {
		findById(id);
		salaRepository.deleteById(id);
	}
	
	public List<Usuario> listarParticipantes(Integer salaId) {
		Sala sala = findById(salaId);
		return sala.getParticipantes();
	}
	
	public Double distance(SalaDTO sala, double lat1, double lon1) {
		double R = 6371;
		double lat2 = sala.getLatitude();
		double lon2 = sala.getLongitude();
		double dLat = Math.toRadians(lat2-lat1);
		double dLon = Math.toRadians(lon2-lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat/2),2) + Math.pow(Math.sin(dLon/2),2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		
		return ((R * c) * 1000);
	}
}
