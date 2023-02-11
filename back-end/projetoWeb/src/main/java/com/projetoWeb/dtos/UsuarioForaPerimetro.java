package com.projetoWeb.dtos;

import java.io.Serializable;
import java.util.Date;
import com.projetoWeb.domain.Alerta;

public class UsuarioForaPerimetro implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nomeUsuario;
	private double latitude;
	private double longitude;
	private Date hora;
	private Boolean notificacaoPersistente;
	private Integer idAlerta;

	public UsuarioForaPerimetro() {
	}

	public UsuarioForaPerimetro(Alerta a) {
		this.nomeUsuario = a.getIdUsuario().getNome();
		this.latitude = a.getLatitude();
		this.longitude = a.getLongitude();
		this.hora = a.getHora();
		this.idAlerta = a.getId();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Boolean getNotificacaoPersistente() {
		return notificacaoPersistente;
	}

	public void setNotificacaoPersistente(Boolean notificacaoPersistente) {
		this.notificacaoPersistente = notificacaoPersistente;
	}

	public Integer getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(Integer idAlerta) {
		this.idAlerta = idAlerta;
	}
	
}
