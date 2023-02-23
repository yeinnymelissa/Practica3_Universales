
package com.practica3.seguni.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="COMPANIAS", schema = "SEGUNI")
@Data
public class Companias implements Serializable{

	private static final long serialVersionUID = -4047601782751066345L;

	@Id
	@Column(name="NOMBRE_COMPANIA")
	private String nombreCompania;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private int numeroVia;
	
	@Column(name="COD_POSTAL")
	private int codPostal;
	
	@Column(name="TELEFONO_CONTRATACION")
	private String telefonoContratacion;
	
	@Column(name="TELEFONO_SINIESTROS")
	private String telefonoSiniestros;
	
	@Column(name="NOTAS")
	private String notas;
	
	@JoinTable(
        name = "COMPANIAS_SEGUROS",
        joinColumns = @JoinColumn(name = "NOMBRE_COMPANIA", nullable = false),
        inverseJoinColumns = @JoinColumn(name="NUMERO_POLIZA", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Seguros> seguros;

}
