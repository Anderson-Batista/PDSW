package com.projetoWeb.controller;

import java.net.URI;
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

import com.projetoWeb.domain.Emergencia;
import com.projetoWeb.dtos.EmergenciaDTO;
import com.projetoWeb.services.EmergenciaService;

@RestController
@RequestMapping(value = "/emergencia")
public class EmergenciaController {

	@Autowired
	private EmergenciaService emergenciaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmergenciaDTO> findById(@PathVariable Integer id) {
		EmergenciaDTO eDTO = new EmergenciaDTO(emergenciaService.findById(id));
		return ResponseEntity.ok().body(eDTO);
	}

	@GetMapping
	public ResponseEntity<List<EmergenciaDTO>> findAll() {
		List<EmergenciaDTO> list = emergenciaService.findAll().stream().map(emergencia -> new EmergenciaDTO(emergencia))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<EmergenciaDTO> create(@RequestBody EmergenciaDTO eDTO) {
		Emergencia e = emergenciaService.create(eDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EmergenciaDTO> update(@PathVariable Integer id, @Valid @RequestBody EmergenciaDTO eDTO) {
		EmergenciaDTO e = new EmergenciaDTO(emergenciaService.update(id, eDTO));
		return ResponseEntity.ok().body(e);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		emergenciaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
