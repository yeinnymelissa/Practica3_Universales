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

@Entity
@Table(name="COMPANIAS", schema = "SEGUNI" )
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



	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public int getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(int numeroVia) {
		this.numeroVia = numeroVia;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getTelefonoContratacion() {
		return telefonoContratacion;
	}

	public void setTelefonoContratacion(String telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}

	public String getTelefonoSiniestros() {
		return telefonoSiniestros;
	}

	public void setTelefonoSiniestros(String telefonoSiniestros) {
		this.telefonoSiniestros = telefonoSiniestros;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public List<Seguros> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguros> seguros) {
		this.seguros = seguros;
	}
	
	
	
}
