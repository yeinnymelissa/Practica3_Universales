
package com.practica3.seguni.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UsuariosDTO implements Serializable{

	private static final long serialVersionUID = 2093784319704084214L;
	private String username;
	private String password;

}
