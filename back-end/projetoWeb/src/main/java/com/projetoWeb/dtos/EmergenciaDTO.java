package com.projetoWeb.dtos;

import java.io.Serializable;

import com.projetoWeb.domain.Emergencia;

public class EmergenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String servico;
	private String telefone;

	public EmergenciaDTO() {
		super();
	}

	public EmergenciaDTO(Emergencia e) {
		super();
		this.id = e.getId();
		this.servico = e.getServico();
		this.telefone = e.getTelefone();
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
}
