package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica3.seguni.entity.Clientes;


@Repository("clientesRepository")
public interface ClientesRepository extends JpaRepository<Clientes, Serializable>{

}
