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

import com.projetoWeb.domain.Alerta;
import com.projetoWeb.dtos.AlertaDTO;
import com.projetoWeb.dtos.EmergenciaDTO;
import com.projetoWeb.services.AlertaService;

@RestController
@RequestMapping(value = "/alerta")
public class AlertaController {

	@Autowired
	private AlertaService alertaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlertaDTO> findById(@PathVariable Integer id) {
		AlertaDTO aDTO = new AlertaDTO(alertaService.findById(id));
		return ResponseEntity.ok().body(aDTO);
	}

	@GetMapping
	public ResponseEntity<List<AlertaDTO>> findAll() {
		List<AlertaDTO> list = alertaService.findAll().stream().map(alerta -> new AlertaDTO(alerta))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<AlertaDTO> create(@RequestBody AlertaDTO aDTO) {
		Alerta a = alertaService.create(aDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AlertaDTO> update(@PathVariable Integer id, @Valid @RequestBody AlertaDTO aDTO) {
		AlertaDTO a = new AlertaDTO(alertaService.update(id, aDTO));
		return ResponseEntity.ok().body(a);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		alertaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/deletAll")
	public ResponseEntity<Void> deleteAll() {
		List<AlertaDTO> list = alertaService.findAll().stream().map(alerta -> new AlertaDTO(alerta))
				.collect(Collectors.toList());
		for (AlertaDTO alertaDTO : list) {
			alertaService.delete(alertaDTO.getId());
		}
		return ResponseEntity.noContent().build();
	}
}
