package com.practica3.seguni.service_interface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica3.seguni.dto.ClientesDTO;
import com.practica3.seguni.dto.CompaniasDTO;
import com.practica3.seguni.dto.CompaniasSegurosDTO;
import com.practica3.seguni.dto.PeritosDTO;
import com.practica3.seguni.dto.SegurosDTO;
import com.practica3.seguni.dto.SiniestrosDTO;
import com.practica3.seguni.dto.UsuariosDTO;
import com.practica3.seguni.entity.Clientes;
import com.practica3.seguni.entity.Companias;
import com.practica3.seguni.entity.CompaniasSeguros;
import com.practica3.seguni.entity.Peritos;
import com.practica3.seguni.entity.Seguros;
import com.practica3.seguni.entity.Siniestros;

@RestController
@RequestMapping("/seguni")
@CrossOrigin
public interface ServiceInt {
	@GetMapping("/auth/consultarClientes")
	public List<Clientes> buscarClientes();
	
	@PostMapping("/auth/guardarClientes")
	public Clientes  guardarClientes(@RequestBody ClientesDTO cliente);
	
	@DeleteMapping("/auth/eliminarCliente/{id}")
	public void eliminarCliente(@PathVariable("id") String id);
	
	@GetMapping("/hola")
	public String  holaMundo();
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UsuariosDTO usuarioDto);
	
	@GetMapping("/auth/consultarSeguros")
	public List<Seguros> buscarSeguros();
	
	@PostMapping("/auth/guardarSeguros")
	public Seguros  guardarSeguros(@RequestBody SegurosDTO seguro);
	
	@DeleteMapping("/auth/eliminarSeguro/{id}")
	public void eliminarSeguro(@PathVariable("id") Integer id);
	
	@PutMapping("/auth/actualizarSeguro")
	public void actualizarSeguro(@RequestBody SegurosDTO seguro);
	
	@GetMapping("/auth/consultarSiniestros")
	public List<Siniestros> buscarSiniestros();
	
	@PostMapping("/auth/guardarSiniestros")
	public Siniestros  guardarSiniestros(@RequestBody SiniestrosDTO siniestro);
	
	@DeleteMapping("/auth/eliminarSiniestro/{id}")
	public void eliminarSiniestro(@PathVariable("id") Integer id);
	
	@PutMapping("/auth/actualizarSiniestro")
	public void actualizarSiniestro(@RequestBody SiniestrosDTO siniestro);
	
	@GetMapping("/auth/consultarPeritos")
	public List<Peritos> buscarPeritos();
	
	@PostMapping("/auth/guardarPeritos")
	public Peritos  guardarPeritos(@RequestBody PeritosDTO perito);
	
	@DeleteMapping("/auth/eliminarPeritos/{id}")
	public void eliminarPeritos(@PathVariable("id") String id);
	
	@GetMapping("/auth/consultarCompanias")
	public List<Companias> buscarCompanias();
	
	@PostMapping("/auth/guardarCompanias")
	public Companias  guardarCompanias(@RequestBody CompaniasDTO compania);
	
	@DeleteMapping("/auth/eliminarCompanias/{id}")
	public void eliminarCompanias(@PathVariable("id") String id);
	
	@GetMapping("/auth/consultarCompaniaSeguros")
	public List<CompaniasSeguros> buscarCompaniaSeguros();
	
	@PostMapping("/auth/guardarCompaniaSeguros")
	public CompaniasSeguros  guardarCompaniaSeguros(@RequestBody CompaniasSegurosDTO comseg);
	
	@DeleteMapping("/auth/eliminarCompaniaSeguros/{id}")
	public void eliminarCompaniaSeguro(@PathVariable("id") Integer id);
	
	@PutMapping("/auth/actualizarCompaniaSeguro")
	public void actualizarCompaniaSeguro(@RequestBody CompaniasSegurosDTO comseg);
}
