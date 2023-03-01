package com.practica3.seguni.service_interface;

import java.util.List;

import org.springframework.data.domain.Page;
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
import com.practica3.seguni.dto.SalidaFuncionDTO;
import com.practica3.seguni.dto.SalidaProcedimientoDTO;
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
	public boolean eliminarCliente(@PathVariable("id") String id);
	
	@GetMapping("/hola")
	public String  holaMundo();
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UsuariosDTO usuarioDto);
	
	@GetMapping("/auth/consultarSeguros")
	public List<Seguros> buscarSeguros();
	
	@PostMapping("/auth/guardarSeguros")
	public Seguros  guardarSeguros(@RequestBody SegurosDTO seguro);
	
	@DeleteMapping("/auth/eliminarSeguro/{id}")
	public boolean eliminarSeguro(@PathVariable("id") Integer id);
	
	@PutMapping("/auth/actualizarSeguro")
	public Seguros actualizarSeguro(@RequestBody SegurosDTO seguro);
	
	@GetMapping("/auth/consultarSiniestros")
	public List<Siniestros> buscarSiniestros();
	
	@PostMapping("/auth/guardarSiniestros")
	public Siniestros  guardarSiniestros(@RequestBody SiniestrosDTO siniestro);
	
	@DeleteMapping("/auth/eliminarSiniestro/{id}")
	public boolean eliminarSiniestro(@PathVariable("id") Integer id);
	
	@PutMapping("/auth/actualizarSiniestro")
	public Siniestros actualizarSiniestro(@RequestBody SiniestrosDTO siniestro);
	
	@GetMapping("/auth/consultarPeritos")
	public List<Peritos> buscarPeritos();
	
	@PostMapping("/auth/guardarPeritos")
	public Peritos  guardarPeritos(@RequestBody PeritosDTO perito);
	
	@DeleteMapping("/auth/eliminarPeritos/{id}")
	public boolean eliminarPeritos(@PathVariable("id") String id);
	
	@GetMapping("/auth/consultarCompanias")
	public List<Companias> buscarCompanias();
	
	@PostMapping("/auth/guardarCompanias")
	public Companias  guardarCompanias(@RequestBody CompaniasDTO compania);
	
	@DeleteMapping("/auth/eliminarCompanias/{id}")
	public boolean eliminarCompanias(@PathVariable("id") String id);
	
	@GetMapping("/auth/consultarCompaniaSeguros")
	public List<CompaniasSeguros> buscarCompaniaSeguros();
	
	@PostMapping("/auth/guardarCompaniaSeguros")
	public CompaniasSeguros  guardarCompaniaSeguros(@RequestBody CompaniasSegurosDTO comseg);
	
	@DeleteMapping("/auth/eliminarCompaniaSeguros/{id}")
	public boolean eliminarCompaniaSeguro(@PathVariable("id") Integer id);
	
	@PutMapping("/auth/actualizarCompaniaSeguro")
	public CompaniasSeguros actualizarCompaniaSeguro(@RequestBody CompaniasSegurosDTO comseg);
	
	@GetMapping("/auth/clientes/buscarInicioCiudad/{ciudad}")
	public List<Clientes> buscarInicioCiudadClientes(@PathVariable("ciudad") String ciudad);
	
	@GetMapping("/auth/clientes/buscarCodPostal/{cod}")
	public List<Clientes> buscarCodPostalClientes(@PathVariable("cod") Integer cod);
	
	@GetMapping("/auth/peritos/buscarInicioNombre/{nom}")
	public List<Peritos> buscarInicioNombrePeritos(@PathVariable("nom") String nom);
	
	@GetMapping("/auth/peritos/buscarTelefono/{tel}")
	public List<Peritos> buscarTelefonoPeritos(@PathVariable("tel") String tel);
	
	@GetMapping("/auth/companias/buscarNumeroViaMayor/{val}")
	public List<Companias> buscarNumeroViaMayorCompanias(@PathVariable("val") Integer val);
	
	@GetMapping("/auth/companias/buscarTelefonoTermina/{tel}")
	public List<Companias> buscarTelefonoTerminaCompanias(@PathVariable("tel") String tel);
	
	@GetMapping("/auth/seguros/buscarRamo/{ramo}")
	public List<Seguros> buscarRamoSeguros(@PathVariable("ramo") String ramo);
	
	@GetMapping("/auth/seguros/buscarFechaInicio/{fecha}")
	public List<Seguros> buscarFechaInicioSeguros(@PathVariable("fecha") String fecha);
	
	@GetMapping("/auth/siniestros/buscarAceptado/{aceptado}")
	public List<Siniestros> buscarAceptadoSiniestros(@PathVariable("aceptado") Character aceptado);
	
	@GetMapping("/auth/siniestros/buscarFechaSiniestro/{fecha}")
	public List<Siniestros> buscarFechaSiniestro(@PathVariable("fecha") String fecha);
	
	@GetMapping("/auth/clientes/buscarNumeroVia/{num}/{pag}")
	public Page<Clientes> verNumViaClientes(@PathVariable("num") Integer num, @PathVariable("pag") Integer pag);

	@GetMapping("/auth/peritos/buscarApellidos/{ape}/{pag}")
	public Page<Peritos> verApellidos(@PathVariable("ape") String ape, @PathVariable("pag") Integer pag);
	
	@GetMapping("/auth/companiasSeguros/buscarSeguros/{num}/{pag}")
	public Page<CompaniasSeguros> verSeguros(@PathVariable("num") Integer num, @PathVariable("pag") Integer pag);
	
	@GetMapping("/funcionProm/{info}/{num1}/{num2}")
	public SalidaFuncionDTO ejectuarFuncionProm(@PathVariable String info,@PathVariable int num1,@PathVariable double num2);
	
	@GetMapping("/procedimiento/{info}/{num1}")
	public SalidaProcedimientoDTO ejectuarProcedimiento(@PathVariable String info,@PathVariable int num1);
}
