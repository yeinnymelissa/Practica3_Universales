package com.practica3.seguni.dto;

import java.io.Serializable;

public class CompaniasSegurosDTO implements Serializable{

	private static final long serialVersionUID = -2833969779234785005L;
	
	private int id;
	private int numeroPoliza;
	private String nombreCompania;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(int numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
}
