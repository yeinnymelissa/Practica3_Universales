package com.practica3.seguni.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import entity.Clientes;

@Repository("clientesRepository")
public interface ClientesRepository extends JpaRepository<Clientes, Serializable>{
	public List<Clientes> findByCiudadStartingWithIgnoreCase(String ciudad);
	public List<Clientes> findByCodPostalEquals(int codPostal);
	
	@Query(value = "SELECT * FROM CLIENTES WHERE NUMERO_VIA >= :val ORDER BY DNI_CL ASC", 
			countQuery = "SELECT COUNT(DNI_CL) FROM CLIENTES",
			nativeQuery = true)
	Page<Clientes> buscarNumViaPaginado(Pageable pageable, @Param("val") Integer val);
}
