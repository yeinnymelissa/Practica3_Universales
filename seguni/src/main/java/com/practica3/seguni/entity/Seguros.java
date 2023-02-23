
package com.practica3.seguni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SEGUROS", schema = "SEGUNI")
@Data
public class Seguros implements Serializable{

	private static final long serialVersionUID = -2878084880149477798L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
		generator="sequenciaSeguros") 
	@SequenceGenerator(name="sequenciaSeguros",sequenceName="sec_seguros", allocationSize=1, initialValue = 1, schema = "SEGUNI")
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
	private String dniCl;
	
	@OneToMany(mappedBy="numeroPoliza")
    private List<Siniestros> siniestro;
	
}
