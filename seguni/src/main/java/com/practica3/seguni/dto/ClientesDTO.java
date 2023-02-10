package com.practica3.seguni.dto;

import java.io.Serializable;

public class ClientesDTO implements Serializable{
	private static final long serialVersionUID = 3781043050513364414L;

	private String dniCl;
	
	private String nombreCl;
	private String apellido1;
	private String apellido2;
	private String claseVia;
	private String nombreVia;
	private int numeroVia;
	private int codPostal;
	private String ciudad;
	private String telefono;
	private String observaciones;



	public String getDniCl() {
		return dniCl;
	}

	public void setDniCl(String dniCl) {
		this.dniCl = dniCl;
	}

	public String getNombreCl() {
		return nombreCl;
	}

	public void setNombreCl(String nombreCl) {
		this.nombreCl = nombreCl;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
