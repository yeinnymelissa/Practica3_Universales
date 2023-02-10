package com.practica3.seguni.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.practica3.seguni.dto.ClientesDTO;
import com.practica3.seguni.dto.UsuariosDTO;
import com.practica3.seguni.entity.Clientes;
import com.practica3.seguni.entity.Usuarios;
import com.practica3.seguni.jwt.JwtTokenInterface;
import com.practica3.seguni.repository.ClientesRepository;
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


}
