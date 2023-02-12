package com.practica3.seguni.entity;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SINIESTROS")
public class Siniestros implements Serializable{

	private static final long serialVersionUID = -103838685420150066L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
					generator="sequenciaSiniestros") 
	@SequenceGenerator(name="sequenciaSiniestros",sequenceName="sec_siniestros", allocationSize=1)
	@Column(name="ID_SINIESTRO")
	private int idSiniestro;
	
	@Column(name="FECHA_SINIESTRO")
	private Date fechaSiniestro;
	
	@Column(name="CAUSAS")
	private String causas;
	
	@Column(name="ACEPTADO")
	private char aceptado;
	
	@Column(name="INDEMNIZACION")
	private double indemnizacion;
	
	@Column(name="NUMERO_POLIZA")
	private int numeroPoliza;
	
	@ManyToOne
    @JoinColumn(name = "DNI_PERITO")
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
