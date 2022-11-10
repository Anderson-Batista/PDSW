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

import com.projetoWeb.domain.Sala;
import com.projetoWeb.dtos.SalaDTO;
import com.projetoWeb.services.SalaService;

@RestController
@RequestMapping(value = "/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
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
		Sala newObj = salaService.create(objDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
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
}







