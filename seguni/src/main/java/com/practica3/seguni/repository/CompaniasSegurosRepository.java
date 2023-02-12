package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.CompaniasSeguros;

@Repository("companiasSegurosRepository")
public interface CompaniasSegurosRepository extends JpaRepository<CompaniasSeguros, Serializable>{

}
