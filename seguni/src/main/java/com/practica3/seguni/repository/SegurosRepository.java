package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.Seguros;

@Repository("segurosRepository")
public interface SegurosRepository extends JpaRepository<Seguros, Serializable>{

}
