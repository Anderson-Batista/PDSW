package com.projetoWeb.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoWeb.domain.Usuario;
import com.projetoWeb.dtos.UsuarioDTO;
import com.projetoWeb.exceptions.ObjectNotFoundException;
import com.projetoWeb.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario create(UsuarioDTO objDTO) {
		return usuarioRepository.save(new Usuario(null, objDTO.getNome(),
				objDTO.getEmail(), objDTO.getTelefone(), objDTO.getSenha()));
	}

	public Usuario update(Integer id, @Valid UsuarioDTO objDTO) {
		Usuario oldObj = findById(id);
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setEmail(objDTO.getEmail());
		oldObj.setTelefone(objDTO.getTelefone());
		oldObj.setSenha(objDTO.getSenha());
		
		return usuarioRepository.save(oldObj);
	}

	public void delete(Integer id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}
}
