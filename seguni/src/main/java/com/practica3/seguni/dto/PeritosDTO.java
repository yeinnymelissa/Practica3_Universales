
package com.practica3.seguni.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PeritosDTO implements Serializable{

	private static final long serialVersionUID = 3656798505616013447L;
	private String dniPerito;
	private String nombrePerito;
	private String apellidoPerito1;
	private String apellidoPerito2;
	private String telefonoContacto;
	private String telefonoOficina;
	private String claseVia;
	private String nombreVia;
	private int numeroVia;
	private int codPostal;
	private String ciudad;

}
