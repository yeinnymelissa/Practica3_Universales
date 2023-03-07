package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.CompaniasSeguros;
@Repository("companiasSegurosRepository")
public interface CompaniasSegurosRepository extends JpaRepository<CompaniasSeguros, Serializable>{
	@Query(value = "SELECT * FROM COMPANIAS_SEGUROS WHERE NUMERO_POLIZA = :val ORDER BY ID ASC", 
			countQuery = "SELECT COUNT(ID) FROM COMPANIAS_SEGUROS",
			nativeQuery = true)
	Page<CompaniasSeguros> buscarPorSeguros(Pageable pageable, @Param("val") Integer val);
}
