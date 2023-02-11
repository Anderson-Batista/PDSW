package com.projetoWeb.dtos;

import java.io.Serializable;

public class UsuarioLocalizacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer usuario;
	private Integer sala;
	private double latitude;
	private double longitude;
	
	public UsuarioLocalizacao() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioLocalizacao(Integer usuario, Integer sala, double latitude, double longitude) {
		super();
		this.usuario = usuario;
		this.sala = sala;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
