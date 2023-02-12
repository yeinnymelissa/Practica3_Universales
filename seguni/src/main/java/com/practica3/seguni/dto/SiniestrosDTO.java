package com.practica3.seguni.dto;

import java.io.Serializable;
import java.util.Date;

import com.practica3.seguni.entity.Peritos;

public class SiniestrosDTO implements Serializable{

	private static final long serialVersionUID = -6097413163678383916L;
	
	private int idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private char aceptado;
	private double indemnizacion;
	private int numeroPoliza;
	private Peritos perito;

	public int getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(int idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public String getCausas() {
		return causas;
	}

	public void setCausas(String causas) {
		this.causas = causas;
	}

	public char getAceptado() {
		return aceptado;
	}

	public void setAceptado(char aceptado) {
		this.aceptado = aceptado;
	}

	public double getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public int getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(int numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Peritos getPerito() {
		return perito;
	}

	public void setPerito(Peritos perito) {
		this.perito = perito;
	}
	
	
}
