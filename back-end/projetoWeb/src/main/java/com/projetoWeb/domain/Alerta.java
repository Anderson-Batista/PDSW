package com.projetoWeb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alerta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private Usuario idUsuario;

	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private Sala idSala;

	private double latitude;
	private double longitude;

	@Temporal(TemporalType.TIMESTAMP)
	private Date hora;

	@OneToMany
	private List<Emergencia> servicosEmergencia;

	public Alerta() {
		super();
	}

	public Alerta(Integer id, Usuario idUsuario, Sala idSala, double latitude, double longitude, Date hora,
			List<Emergencia> servicosEmergencia) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idSala = idSala;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hora = hora;
		this.servicosEmergencia = servicosEmergencia;
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

	public List<Emergencia> getServicosEmergencia() {
		return servicosEmergencia;
	}

	public void setServicosEmergencia(List<Emergencia> servicosEmergencia) {
		this.servicosEmergencia = servicosEmergencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hora, id, latitude, longitude, servicosEmergencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alerta other = (Alerta) obj;
		return Objects.equals(hora, other.hora) && Objects.equals(id, other.id)
				&& Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude)
				&& Objects.equals(servicosEmergencia, other.servicosEmergencia);
	}

	@Override
	public String toString() {
		return "Alerta [id=" + id + ", idUsuario=" + idUsuario + ", idSala=" + idSala + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", hora=" + hora + ", servicosEmergencia=" + servicosEmergencia + "]";
	}
}
