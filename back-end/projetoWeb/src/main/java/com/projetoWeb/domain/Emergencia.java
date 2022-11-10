package com.projetoWeb.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emergencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String servico;
	private String telefone;

	public void fazerLigacao() {
		// TODO
	}

	public Emergencia() {
		super();
	}

	public Emergencia(Integer id, String servico, String telefone) {
		super();
		this.id = id;
		this.servico = servico;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, servico, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emergencia other = (Emergencia) obj;
		return Objects.equals(id, other.id) && Objects.equals(servico, other.servico)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Emergencia [id=" + id + ", servico=" + servico + ", telefone=" + telefone + "]";
	}
}
