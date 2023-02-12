package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.Peritos;

@Repository("peritosRepository")
public interface PeritosRepository extends JpaRepository<Peritos, Serializable>{

}
