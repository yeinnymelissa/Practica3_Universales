package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.Companias;

@Repository("companiasRepository")
public interface CompaniasRepository extends JpaRepository<Companias, Serializable>{

}
