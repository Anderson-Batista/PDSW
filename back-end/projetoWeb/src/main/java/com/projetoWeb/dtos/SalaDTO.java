package com.projetoWeb.dtos;

import java.io.Serializable;
import java.util.List;

import com.projetoWeb.domain.Sala;
import com.projetoWeb.domain.Usuario;

public class SalaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String link;
	private double perimetro;
	private double longitude;
	private double latitude;
	private Boolean notificacaoPersistente;
	private Boolean salaIniciada;
	
	private Usuario usuario;
	
	private List<Usuario> participantes;

	public SalaDTO() {
	}

	public SalaDTO(Sala obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.link = obj.getLink();
		this.perimetro = obj.getPerimetro();
		this.longitude = obj.getLongitude();
		this.latitude = obj.getLatitude();
		this.usuario = obj.getUsuario();
		this.participantes = obj.getParticipantes();
		this.notificacaoPersistente = obj.getNotificacaoPersistente();
		this.salaIniciada = obj.getSalaIniciada();
	}
	
	public SalaDTO(Integer id, String nome, String link, double perimetro, double longitude, double latitude,
			Boolean notificacaoPersistente, Boolean salaIniciada, Usuario usuario, List<Usuario> participantes) {
		super();
		this.id = id;
		this.nome = nome;
		this.link = link;
		this.perimetro = perimetro;
		this.longitude = longitude;
		this.latitude = latitude;
		this.notificacaoPersistente = notificacaoPersistente;
		this.salaIniciada = salaIniciada;
		this.usuario = usuario;
		this.participantes = participantes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public Boolean getNotificacaoPersistente() {
		return notificacaoPersistente;
	}

	public void setNotificacaoPersistente(Boolean notificacaoPersistente) {
		this.notificacaoPersistente = notificacaoPersistente;
	}

	public Boolean getSalaIniciada() {
		return salaIniciada;
	}

	public void setSalaIniciada(Boolean salaIniciada) {
		this.salaIniciada = salaIniciada;
	}
	
}
