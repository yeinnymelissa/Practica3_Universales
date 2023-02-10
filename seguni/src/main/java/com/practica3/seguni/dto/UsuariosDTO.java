package com.practica3.seguni.dto;

import java.io.Serializable;


public class UsuariosDTO implements Serializable{

	private static final long serialVersionUID = 2093784319704084214L;

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
