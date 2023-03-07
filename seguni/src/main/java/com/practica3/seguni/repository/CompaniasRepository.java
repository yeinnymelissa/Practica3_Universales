package com.practica3.seguni.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Companias;
@Repository("companiasRepository")
public interface CompaniasRepository extends JpaRepository<Companias, Serializable>{
	public List<Companias> findByNumeroViaGreaterThan(Integer nombreVia);
	public List<Companias> findByTelefonoContratacionEndingWith(String telContratacion);
}
