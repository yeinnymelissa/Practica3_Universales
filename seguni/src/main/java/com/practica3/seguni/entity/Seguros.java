package com.practica3.seguni.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="SEGUROS")
public class Seguros implements Serializable{

	private static final long serialVersionUID = -2878084880149477798L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
		generator="sequenciaSeguros") 
	@SequenceGenerator(name="sequenciaSeguros",sequenceName="sec_seguros", allocationSize=1)
	@Column(name="NUMERO_POLIZA")
	private int numeroPoliza;
	
	@Column(name="RAMO")
	private String ramo;
	
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;
	
	@Column(name="CONDICIONES_PARTICULARES")
	private String condicionesParticulares;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@Column(name="DNI_CL")
	private int dniCl;

	public int getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(int numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionesParticulares() {
		return condicionesParticulares;
	}

	public void setCondicionesParticulares(String condicionesParticulares) {
		this.condicionesParticulares = condicionesParticulares;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getDniCl() {
		return dniCl;
	}

	public void setDniCl(int dniCl) {
		this.dniCl = dniCl;
	}
	
}
