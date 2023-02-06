package com.projetoWeb;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetoWeb.domain.Alerta;
import com.projetoWeb.domain.Emergencia;
import com.projetoWeb.domain.Sala;
import com.projetoWeb.domain.Usuario;
import com.projetoWeb.repositories.AlertaRepository;
import com.projetoWeb.repositories.EmergenciaRepository;
import com.projetoWeb.repositories.SalaRepository;
import com.projetoWeb.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoWebApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private EmergenciaRepository emergenciaRepository;

	@Autowired
	private AlertaRepository alertaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario anderson = new Usuario(null, "Anderson Batista", "anderson@email.com", "81 9999-8888", "1234");
		Usuario davidson = new Usuario(null, "Davidson", "davidson@email.com", "81 7777-6666", "1122");
		Usuario dudu = new Usuario(null, "Dudu Freitas", "dudu_freitas@email.com", "81 5555-4444", "2233");
		Usuario nelson = new Usuario(null, "Nelson da Captinga", "nerso@email.com", "81 3333-2222", "4455");

		usuarioRepository.saveAll(Arrays.asList(anderson, davidson, dudu, nelson));

		Sala sala1 = new Sala(null, "Congraternização", "linkteste.com", 0, 349498.0, 80586.0, nelson,
				Arrays.asList(), true);

		salaRepository.saveAll(Arrays.asList(sala1));

		Emergencia emergencia = new Emergencia(null, "Polícia", "190");
		Emergencia emergencia2 = new Emergencia(null, "Bombeiros", "193");
		emergenciaRepository.saveAll(Arrays.asList(emergencia, emergencia2));

		Alerta alerta = new Alerta(null, anderson, sala1, "111111", "222222", new Date(), Arrays.asList(emergencia, emergencia2));
		alertaRepository.saveAll(Arrays.asList(alerta));
	}
}
