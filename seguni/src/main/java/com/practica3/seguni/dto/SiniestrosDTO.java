
package com.practica3.seguni.dto;

import java.io.Serializable;
import java.util.Date;
import entity.Peritos;
import lombok.Data;

@Data
public class SiniestrosDTO implements Serializable{

	private static final long serialVersionUID = -6097413163678383916L;
	private int idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private char aceptado;
	private double indemnizacion;
	private int numeroPoliza;
	private Peritos perito;

}
