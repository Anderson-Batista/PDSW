package com.projetoWeb.dtos;

public class LoginObject {
	private String email;
	private String senha;
	
	public LoginObject() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginObject(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
