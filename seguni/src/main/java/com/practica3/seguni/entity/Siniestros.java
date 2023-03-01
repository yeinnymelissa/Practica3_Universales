
package com.practica3.seguni.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SINIESTROS", schema = "SEGUNI")
@Data
public class Siniestros implements Serializable{

	private static final long serialVersionUID = -103838685420150066L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,
					generator="sequenciaSiniestros") 
	@SequenceGenerator(name="sequenciaSiniestros",sequenceName="sec_siniestros", allocationSize=1, initialValue = 1, schema = "SEGUNI")
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
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DNI_PERITO")
	private Peritos perito;
	
}
