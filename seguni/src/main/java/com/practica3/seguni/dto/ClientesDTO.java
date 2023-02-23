
package com.practica3.seguni.dto;

import java.io.Serializable;
import lombok.Data;

@Data
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

}
