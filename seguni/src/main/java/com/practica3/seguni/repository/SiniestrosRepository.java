package com.practica3.seguni.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.Siniestros;

@Repository("siniestrosRepository")
public interface SiniestrosRepository extends JpaRepository<Siniestros, Serializable>{
	public List<Siniestros> findByAceptadoLikeOrderByIdSiniestroAsc(char aceptado);
	public List<Siniestros> findByFechaSiniestroAfterOrderByIdSiniestroAsc(Date fechaInicio);
}
