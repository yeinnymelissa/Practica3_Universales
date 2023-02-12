package com.practica3.seguni.dto;

import java.io.Serializable;


public class CompaniasDTO implements Serializable{

	private static final long serialVersionUID = 2255669706323340658L;

	private String nombreCompania;
	private String claseVia;
	private String nombreVia;
	private int numeroVia;
	private int codPostal;
	private String telefonoContratacion;
	private String telefonoSiniestros;
	private String notas;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}


	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public int getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(int numeroVia) {
		this.numeroVia = numeroVia;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getTelefonoContratacion() {
		return telefonoContratacion;
	}

	public void setTelefonoContratacion(String telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}

	public String getTelefonoSiniestros() {
		return telefonoSiniestros;
	}

	public void setTelefonoSiniestros(String telefonoSiniestros) {
		this.telefonoSiniestros = telefonoSiniestros;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
}
