package com.practica3.seguni.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Usuarios;

@Repository("usuariosRepository")
public interface UsuariosRepository extends JpaRepository<Usuarios, Serializable>{
	public Usuarios findByUsernameAndPassword(String usern, String pass); 
}
