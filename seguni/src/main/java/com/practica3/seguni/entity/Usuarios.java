
package com.practica3.seguni.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USUARIOS", schema = "SEGUNI")
@Data
public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 5102227664867517990L;

	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

}
