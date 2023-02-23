package com.practica3.seguni.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniasSegurosDTO implements Serializable{

	private static final long serialVersionUID = -2833969779234785005L;
	
	private int id;
	private int numeroPoliza;
	private String nombreCompania;

}
