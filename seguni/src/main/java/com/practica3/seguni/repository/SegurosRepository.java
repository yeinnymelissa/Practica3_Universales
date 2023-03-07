package com.practica3.seguni.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Seguros;

@Repository("segurosRepository")
public interface SegurosRepository extends JpaRepository<Seguros, Serializable>{
	public List<Seguros> findByRamoLikeIgnoreCaseOrderByNumeroPolizaAsc(String ramo);
	public List<Seguros> findByFechaInicioBeforeOrderByNumeroPolizaDesc(Date fechaInicio);
}
