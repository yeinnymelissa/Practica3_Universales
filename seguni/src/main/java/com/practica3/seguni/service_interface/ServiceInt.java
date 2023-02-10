package com.practica3.seguni.service_interface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica3.seguni.dto.ClientesDTO;
import com.practica3.seguni.dto.UsuariosDTO;
import com.practica3.seguni.entity.Clientes;

@RestController
@RequestMapping("/seguni")
@CrossOrigin
public interface ServiceInt {
	@GetMapping("/auth/consultarClientes")
	public List<Clientes> buscarClientes();
	
	@PostMapping("/auth/guardarClientes")
	public Clientes  guardarClientes(@RequestBody ClientesDTO cliente);
	
	@GetMapping("/hola")
	public String  holaMundo();
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UsuariosDTO usuarioDto);
}
