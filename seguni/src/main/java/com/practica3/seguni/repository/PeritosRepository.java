package com.practica3.seguni.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.Peritos;

@Repository("peritosRepository")
public interface PeritosRepository extends JpaRepository<Peritos, Serializable>{

	public List<Peritos> findByNombrePeritoStartingWithIgnoreCase(String nombre);
	public List<Peritos> findByTelefonoContactoStartingWithIgnoreCase(String telefono);
	
	@Query(value = "SELECT * FROM PERITOS WHERE LOWER(APELLIDO_PERITO1) LIKE :val%  ORDER BY DNI_PERITO ASC", 
			countQuery = "SELECT COUNT(DNI_PERITO) FROM PERITOS",
			nativeQuery = true)
	Page<Peritos> buscarApellidosPaginado(Pageable pageable, @Param("val") String val);
}
