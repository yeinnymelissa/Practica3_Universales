package com.practica3.seguni.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SegurosDTO implements Serializable{

	private static final long serialVersionUID = 6065330753942283864L;

	private int numeroPoliza;
	
	private String ramo;
	
	private Date fechaInicio;
	
	private Date fechaVencimiento;
	
	private String condicionesParticulares;
	
	private String observaciones;
	
	private String dniCl;

}
