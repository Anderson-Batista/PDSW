package com.projetoWeb;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projetoWeb.domain.Usuario;
import com.projetoWeb.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoWebApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario anderson = new Usuario(null, "Anderson Batista", "anderson@email.com", "81 9999-8888", "1234");
		Usuario davidson = new Usuario(null, "Davidson", "davidson@email.com", "81 7777-6666", "1234");
		Usuario dudu = new Usuario(null, "Dudu Freitas", "dudu@email.com", "81 5555-4444", "1234");
		Usuario nelson = new Usuario(null, "Nelson da Captinga", "nerso@email.com", "81 3333-2222", "1234");

		usuarioRepository.saveAll(Arrays.asList(anderson, davidson, dudu, nelson));

	}
}
