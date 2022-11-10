package com.projetoWeb.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.projetoWeb.domain.Alerta;
import com.projetoWeb.domain.Emergencia;
import com.projetoWeb.domain.Sala;
import com.projetoWeb.domain.Usuario;

public class AlertaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Usuario idUsuario;
	private Sala idSala;
	private String latitude;
	private String longitude;
	private Date hora;
	private List<Emergencia> servicosEmergencia;

	public AlertaDTO() {

	}

	public AlertaDTO(Alerta a) {
		super();
		this.id = a.getId();
		this.idUsuario = a.getIdUsuario();
		this.idSala = a.getIdSala();
		this.latitude = a.getLatitude();
		this.longitude = a.getLongitude();
		this.hora = a.getHora();
		this.servicosEmergencia = a.getServicosEmergencia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Sala getIdSala() {
		return idSala;
	}

	public void setIdSala(Sala idSala) {
		this.idSala = idSala;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public List<Emergencia> getServicosEmergencia() {
		return servicosEmergencia;
	}

	public void setServicosEmergencia(List<Emergencia> servicosEmergencia) {
		this.servicosEmergencia = servicosEmergencia;
	}
}
