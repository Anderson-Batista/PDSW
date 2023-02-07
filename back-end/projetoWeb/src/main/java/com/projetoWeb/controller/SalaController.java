package com.projetoWeb.controller;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;
import com.projetoWeb.domain.Sala;
import com.projetoWeb.domain.Usuario;
import com.projetoWeb.dtos.SalaDTO;
import com.projetoWeb.dtos.UsuarioDTO;
import com.projetoWeb.services.SalaService;
import com.projetoWeb.services.UsuarioService;

@RestController
@RequestMapping(value = "/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	public ResponseEntity<String> create(@RequestBody SalaDTO objDTO) {
		objDTO.setParticipantes(new ArrayList<>());
		objDTO.getParticipantes().add(objDTO.getUsuario());
		Sala newObj = salaService.create(objDTO);
		SalaDTO salaDTO = new SalaDTO(newObj);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(salaDTO);
		
		return ResponseEntity.ok().body(jsonStr);
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
}







