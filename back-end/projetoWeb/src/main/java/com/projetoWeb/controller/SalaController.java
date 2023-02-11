package com.projetoWeb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoWeb.domain.Alerta;
import com.projetoWeb.domain.Sala;
import com.projetoWeb.domain.Usuario;
import com.projetoWeb.dtos.AlertaDTO;
import com.projetoWeb.dtos.SalaDTO;
import com.projetoWeb.dtos.UsuarioDTO;
import com.projetoWeb.dtos.UsuarioForaPerimetro;
import com.projetoWeb.dtos.UsuarioLocalizacao;
import com.projetoWeb.services.AlertaService;
import com.projetoWeb.services.SalaService;
import com.projetoWeb.services.UsuarioService;

@RestController
@RequestMapping(value = "/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AlertaService alertaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SalaDTO> findById(@PathVariable Integer id){
		SalaDTO objDTO = new SalaDTO(salaService.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<SalaDTO>> findAll(){
		List<SalaDTO> listDTO = salaService.findAll()
				.stream().map(obj -> new SalaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<SalaDTO> create(@RequestBody SalaDTO objDTO) {
		objDTO.setParticipantes(new ArrayList<>());
		objDTO.getParticipantes().add(objDTO.getUsuario());
		Sala newObj = salaService.create(objDTO);
		SalaDTO salaDTO = new SalaDTO(newObj);
		
		return ResponseEntity.ok().body(salaDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SalaDTO> update(@PathVariable Integer id, @Valid @RequestBody SalaDTO objDTO){
		SalaDTO newObj = new SalaDTO(salaService.update(id, objDTO));
	
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		salaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/entrarSala/{salaIsd}")
	public void entrarSala(@RequestBody UsuarioDTO objDTO, @PathVariable Integer salaId) {
		SalaDTO sala = new SalaDTO(salaService.findById(salaId));
		Usuario usuario = usuarioService.create(objDTO);
		sala.getParticipantes().add(usuario);
		salaService.update(salaId, sala);
	}
	
	
	@GetMapping(value = "/listarParticipantes/{id}")
	public ResponseEntity<List<UsuarioDTO>> listarParticipantes(@PathVariable Integer id){
		List<Usuario> listUsuarios = salaService.listarParticipantes(id);
		List<UsuarioDTO> result = new ArrayList<>();
		for (Usuario usuario : listUsuarios) {
			result.add(new UsuarioDTO(usuario));
		}
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping(value = "/localizacaoUsuario")
	public ResponseEntity<UsuarioForaPerimetro> localizacaoUsuario(@RequestBody UsuarioLocalizacao usrLoc) {
		Sala sala = salaService.findById(usrLoc.getSala());
		Usuario usuario = usuarioService.findById(usrLoc.getUsuario());
		double latitude = usrLoc.getLatitude();
		double longitude = usrLoc.getLongitude();
		
		List<Alerta> listAlerta = alertaService.findAll();
		
		for (Alerta alertaDTO : listAlerta) {
			if(alertaDTO.getIdSala().getId().equals(sala.getId())) {
				UsuarioForaPerimetro userFPr= new UsuarioForaPerimetro(alertaDTO);
				userFPr.setNotificacaoPersistente(sala.getNotificacaoPersistente());
				return ResponseEntity.ok().body(userFPr);
			} else if(alertaDTO.getIdUsuario().getId().equals(alertaDTO.getId())) {
				return ResponseEntity.ok().body(null);
			}
		}
		
		double distanciaUser = salaService.distance(new SalaDTO(sala), usrLoc.getLatitude(), usrLoc.getLongitude());
		
		if((distanciaUser > sala.getPerimetro()) && listAlerta.size() == 0) {
			AlertaDTO novoAlerta = new AlertaDTO();
			novoAlerta.setHora(new Date());
			novoAlerta.setIdSala(sala);
			novoAlerta.setIdUsuario(usuario);
			novoAlerta.setLatitude(latitude);
			novoAlerta.setLongitude(longitude);
			
			alertaService.create(novoAlerta);
		}
		
		return ResponseEntity.ok().body(null);
		
	}
	
}







