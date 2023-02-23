
package com.practica3.seguni.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="COMPANIAS_SEGUROS", schema = "SEGUNI")
@Data
public class CompaniasSeguros implements Serializable{

	private static final long serialVersionUID = 680425397304454943L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
		generator="secuenciaComseg") 
	@SequenceGenerator(name="secuenciaComseg",sequenceName="sec_comseg", allocationSize=1, initialValue = 1, schema = "SEGUNI")
	@Column(name="ID")
	private int id;
	
	@Column(name="NUMERO_POLIZA")
	private int numeroPoliza;
	
	@Column(name="NOMBRE_COMPANIA")
	private String nombreCompania;

}
