package com.projetoWeb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sala implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String link;
	private double perimetro;
	private double longitude;
	private double latitude;
	private Boolean notificacaoPersistente;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany
	private List<Usuario> participantes;

	public Sala() {
	}

	public Sala(Integer id, String nome, String link, double perimetro, double longitude, double latitude,
			Usuario usuario, List<Usuario> participantes, Boolean notificacaoPersistente) {
		this.id = id;
		this.nome = nome;
		this.link = link;
		this.perimetro = perimetro;
		this.longitude = longitude;
		this.latitude = latitude;
		this.usuario = usuario;
		this.participantes = participantes;
		this.notificacaoPersistente = notificacaoPersistente;
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
	
}
