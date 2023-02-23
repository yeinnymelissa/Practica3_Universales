
package com.practica3.seguni.dto;

import java.io.Serializable;
import lombok.Data;

@Data
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

}
