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

import com.projetoWeb.domain.Usuario;
import com.projetoWeb.dtos.LoginObject;
import com.projetoWeb.dtos.UsuarioDTO;
import com.projetoWeb.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
		UsuarioDTO objDTO = new UsuarioDTO(usuarioService.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<UsuarioDTO> listDTO = usuarioService.findAll()
				.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO objDTO) {
		Usuario newObj = usuarioService.create(objDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO objDTO){
		UsuarioDTO newObj = new UsuarioDTO(usuarioService.update(id, objDTO));
	
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<UsuarioDTO> findById(@RequestBody LoginObject login){
		List<UsuarioDTO> listDTO = usuarioService.findAll()
				.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		
		for (UsuarioDTO usuarioDTO : listDTO) {
			if(usuarioDTO.getEmail().equals(login.getEmail()) && usuarioDTO.getSenha().equals(login.getSenha())) {
				return ResponseEntity.ok().body(usuarioDTO);
			}
		}
		return ResponseEntity.ok().body(null);
	}
}







