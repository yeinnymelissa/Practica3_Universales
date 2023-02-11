package com.practica3.seguni.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.practica3.seguni.dto.ClientesDTO;
import com.practica3.seguni.dto.SegurosDTO;
import com.practica3.seguni.dto.UsuariosDTO;
import com.practica3.seguni.entity.Clientes;
import com.practica3.seguni.entity.Seguros;
import com.practica3.seguni.entity.Usuarios;
import com.practica3.seguni.jwt.JwtTokenInterface;
import com.practica3.seguni.repository.ClientesRepository;
import com.practica3.seguni.repository.SegurosRepository;
import com.practica3.seguni.repository.UsuariosRepository;
import com.practica3.seguni.service_interface.ServiceInt;

@Component
public class ServiceWS implements ServiceInt{
	
	@Autowired
	ClientesRepository cr;
	
	@Autowired
	UsuariosRepository ur;
	
	@Autowired
	JwtTokenInterface jwtGenerator;
	
	@Autowired
	SegurosRepository sr;
	
	@Override
	public List<Clientes> buscarClientes() {
		return cr.findAll();
	}

	@Override
	public Clientes guardarClientes(ClientesDTO cliente) {
		Clientes cli = new Clientes();
		
		cli.setDniCl(cliente.getDniCl());
		cli.setNombreCl(cliente.getNombreCl());
		cli.setApellido1(cliente.getApellido1());
		cli.setApellido2(cliente.getApellido2());
		cli.setClaseVia(cliente.getClaseVia());
		cli.setNombreVia(cliente.getNombreVia());
		cli.setNumeroVia(cliente.getNumeroVia());
		cli.setCodPostal(cliente.getCodPostal());
		cli.setCiudad(cliente.getCiudad());
		cli.setTelefono(cliente.getTelefono());
		cli.setObservaciones(cliente.getObservaciones());
		return cr.save(cli);
	}

	@Override
	public String holaMundo() {
		return "HOLA";
	}

	@Override
	public ResponseEntity<Object> login(UsuariosDTO usuarioDto) {
		try {
	      if(usuarioDto.getUsername() == null || usuarioDto.getPassword() == null) {
	      return new ResponseEntity<>("Usuario o password vacio.", HttpStatus.BAD_REQUEST);
	      }
			Usuarios usuarioTest = ur.findByUsernameAndPassword(usuarioDto.getUsername(), usuarioDto.getPassword());
			if(usuarioTest == null) {
				return new ResponseEntity<>("Usuario o password invalido.", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(usuarioTest), HttpStatus.OK);
	    } catch (Exception e) {
	       return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Override
	public void eliminarCliente(String id) {
		Optional<Clientes> cliDel = cr.findById(id);
		
		if(cliDel.isPresent()){
			
			List<Seguros> seg = cliDel.get().getSeguro();
			sr.deleteAll(seg);
			
			cr.delete(cliDel.get());
			
		}
		
	}

	@Override
	public List<Seguros> buscarSeguros() {
		return sr.findAll();
	}

	@Override
	public Seguros guardarSeguros(SegurosDTO seguro) {
		
		Seguros seg = new Seguros();
		
		seg.setNumeroPoliza(seguro.getNumeroPoliza());
		seg.setRamo(seguro.getRamo());
		seg.setFechaInicio(seguro.getFechaInicio());
		seg.setFechaVencimiento(seguro.getFechaVencimiento());
		seg.setCondicionesParticulares(seguro.getCondicionesParticulares());
		seg.setObservaciones(seguro.getObservaciones());
		seg.setDniCl(seguro.getDniCl());
		return sr.save(seg);
	}

	@Override
	public void eliminarSeguro(Integer id) {
		sr.deleteById(id);
	}

	@Override
	public void actualizarSeguro(SegurosDTO seguro) {
		Optional<Seguros> segUp = sr.findById(seguro.getNumeroPoliza());
		if(segUp.isPresent()){
			segUp.get().setRamo(seguro.getRamo());
			segUp.get().setFechaInicio(seguro.getFechaInicio());
			segUp.get().setFechaVencimiento(seguro.getFechaVencimiento());
			segUp.get().setCondicionesParticulares(seguro.getCondicionesParticulares());
			segUp.get().setObservaciones(seguro.getObservaciones());
			segUp.get().setDniCl(seguro.getDniCl());
			sr.save(segUp.get());
			
		}
	}



}
