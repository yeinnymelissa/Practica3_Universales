
package com.practica3.seguni.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.practica3.seguni.dto.ClientesDTO;
import com.practica3.seguni.dto.CompaniasDTO;
import com.practica3.seguni.dto.CompaniasSegurosDTO;
import com.practica3.seguni.dto.PeritosDTO;
import com.practica3.seguni.dto.SalidaFuncionDTO;
import com.practica3.seguni.dto.SalidaProcedimientoDTO;
import com.practica3.seguni.dto.SegurosDTO;
import com.practica3.seguni.dto.SiniestrosDTO;
import com.practica3.seguni.dto.UsuariosDTO;
import entity.Clientes;
import entity.Companias;
import entity.CompaniasSeguros;
import entity.Peritos;
import entity.Seguros;
import entity.Siniestros;
import entity.Usuarios;
import com.practica3.seguni.jwt.JwtTokenInterface;
import com.practica3.seguni.repository.ClientesRepository;
import com.practica3.seguni.repository.CompaniasRepository;
import com.practica3.seguni.repository.CompaniasSegurosRepository;
import com.practica3.seguni.repository.PeritosRepository;
import com.practica3.seguni.repository.SegurosRepository;
import com.practica3.seguni.repository.SiniestrosRepository;
import com.practica3.seguni.repository.UsuariosRepository;
import com.practica3.seguni.service.ServicioGeneral;
import com.practica3.seguni.service_interface.ServiceInt;

@Component
public class ServiceWS implements ServiceInt{
	
	private static final Log LOG = LogFactory.getLog(ServiceWS.class);
	
	@Autowired
	ClientesRepository cr;
	
	@Autowired
	UsuariosRepository ur;
	
	@Autowired
	JwtTokenInterface jwtGenerator;
	
	@Autowired
	SegurosRepository sr;
	
	@Autowired
	SiniestrosRepository sir;
	
	@Autowired
	PeritosRepository pr;
	
	@Autowired
	CompaniasRepository comr;
	
	@Autowired
	CompaniasSegurosRepository csr;
	
	@Autowired
	ServicioGeneral sg;
	
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
	public boolean eliminarCliente(String id) {
		Optional<Clientes> cliDel = cr.findById(id);
		
		if(cliDel.isPresent()){
			
			List<Seguros> seg = cliDel.get().getSeguro();
			for(Seguros segu : seg) {
				Optional<Seguros> segDel = sr.findById(segu.getNumeroPoliza());
				if(segDel.isPresent()) {
					sir.deleteAll(segDel.get().getSiniestro());
					sr.delete(segDel.get());
				}
			}
			sr.deleteAll(seg);
			
			cr.delete(cliDel.get());
			return true;
			
		}
		
		return false;
		
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
	public boolean eliminarSeguro(Integer id) {
		Optional<Seguros> segDel = sr.findById(id);
		
		if(segDel.isPresent()){
			
			List<Siniestros> siniestros = segDel.get().getSiniestro();
			sir.deleteAll(siniestros);
			sr.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Seguros actualizarSeguro(SegurosDTO seguro) {
		Optional<Seguros> segUp = sr.findById(seguro.getNumeroPoliza());
		if(segUp.isPresent()){
			segUp.get().setRamo(seguro.getRamo());
			segUp.get().setFechaInicio(seguro.getFechaInicio());
			segUp.get().setFechaVencimiento(seguro.getFechaVencimiento());
			segUp.get().setCondicionesParticulares(seguro.getCondicionesParticulares());
			segUp.get().setObservaciones(seguro.getObservaciones());
			segUp.get().setDniCl(seguro.getDniCl());
			return sr.save(segUp.get());
			
		}
		return null;
	}

	@Override
	public List<Siniestros> buscarSiniestros() {
		for(Siniestros sin : sir.findAll()) {
			if(sin.getPerito() == null) {
				sir.delete(sin);
			}
		}
		return sir.findAll();
	}

	@Override
	public Siniestros guardarSiniestros(SiniestrosDTO siniestro) {
		
		Siniestros sin = new Siniestros();
		
		sin.setIdSiniestro(siniestro.getIdSiniestro());
		sin.setFechaSiniestro(siniestro.getFechaSiniestro());
		sin.setCausas(siniestro.getCausas());
		sin.setAceptado(siniestro.getAceptado());
		sin.setIndemnizacion(siniestro.getIndemnizacion());
		sin.setNumeroPoliza(siniestro.getNumeroPoliza());
		sin.setPerito(siniestro.getPerito());
		
		return sir.save(sin);
	}

	@Override
	public boolean eliminarSiniestro(Integer id) {
		Optional<Siniestros> sinDel = sir.findById(id);
		
		if(sinDel.isPresent()){
			sir.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Siniestros actualizarSiniestro(SiniestrosDTO siniestro) {
		Optional<Siniestros> sinUp = sir.findById(siniestro.getIdSiniestro());
		
		if(sinUp.isPresent()){
			sinUp.get().setFechaSiniestro(siniestro.getFechaSiniestro());
			sinUp.get().setCausas(siniestro.getCausas());
			sinUp.get().setAceptado(siniestro.getAceptado());
			sinUp.get().setIndemnizacion(siniestro.getIndemnizacion());
			sinUp.get().setNumeroPoliza(siniestro.getNumeroPoliza());
			sinUp.get().setPerito(siniestro.getPerito());
			return sir.save(sinUp.get());
		}
		
		return null;
	}

	@Override
	public List<Peritos> buscarPeritos() {
		return pr.findAll();
	}

	@Override
	public Peritos guardarPeritos(PeritosDTO perito) {
		ModelMapper mp = new ModelMapper();
		Peritos peri = new Peritos();
		mp.map(perito, peri);
		return pr.save(peri);
	}

	@Override
	public boolean eliminarPeritos(String id) {
		Optional <Peritos> periDel =  pr.findById(id);
		if(periDel.isPresent()) {
			pr.delete(periDel.get());
			return true;
		}
		return false;
	}

	@Override
	public List<Companias> buscarCompanias() {
		return comr.findAll();
	}

	@Override
	public Companias guardarCompanias(CompaniasDTO compania) {
		Companias compa = new Companias();
		
		compa.setNombreCompania(compania.getNombreCompania());
		compa.setClaseVia(compania.getClaseVia());
		compa.setNombreVia(compania.getNombreVia());
		compa.setNumeroVia(compania.getNumeroVia());
		compa.setCodPostal(compania.getCodPostal());
		compa.setTelefonoContratacion(compania.getTelefonoContratacion());
		compa.setTelefonoSiniestros(compania.getTelefonoSiniestros());
		compa.setNotas(compania.getNotas());
		return comr.save(compa);
	}

	@Override
	public boolean eliminarCompanias(String id) {
		Optional<Companias> comDel = comr.findById(id);
		
		if(comDel.isPresent()){
			comr.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<CompaniasSeguros> buscarCompaniaSeguros() {
		return csr.findAll();
	}

	@Override
	public CompaniasSeguros guardarCompaniaSeguros(CompaniasSegurosDTO comseg) {
		CompaniasSeguros comSeguros = new CompaniasSeguros();
		
		comSeguros.setId(comseg.getId());
		comSeguros.setNombreCompania(comseg.getNombreCompania());
		comSeguros.setNumeroPoliza(comseg.getNumeroPoliza());
		
		return csr.save(comSeguros);
	}

	@Override
	public boolean eliminarCompaniaSeguro(Integer id) {
		Optional<CompaniasSeguros> comDel = csr.findById(id);
		
		if(comDel.isPresent()){
			csr.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public CompaniasSeguros actualizarCompaniaSeguro(CompaniasSegurosDTO comseg) {
		Optional<CompaniasSeguros> comDel = csr.findById(comseg.getId());
		
		if(comDel.isPresent()){
			comDel.get().setId(comseg.getId());
			comDel.get().setNombreCompania(comseg.getNombreCompania());
			comDel.get().setNumeroPoliza(comseg.getNumeroPoliza());
			
			return csr.save(comDel.get());
		}
		return null;
	}

	@Override
	public List<Clientes> buscarInicioCiudadClientes(String ciudad) {
		return cr.findByCiudadStartingWithIgnoreCase(ciudad);
	}

	@Override
	public List<Clientes> buscarCodPostalClientes(Integer cod) {
		return cr.findByCodPostalEquals(cod);
	}

	@Override
	public List<Peritos> buscarInicioNombrePeritos(String nom) {
		return pr.findByNombrePeritoStartingWithIgnoreCase(nom);
	}

	@Override
	public List<Peritos> buscarTelefonoPeritos(String tel) {
		return pr.findByTelefonoContactoStartingWithIgnoreCase(tel);
	}

	@Override
	public List<Companias> buscarNumeroViaMayorCompanias(Integer val) {
		return comr.findByNumeroViaGreaterThan(val);
	}

	@Override
	public List<Companias> buscarTelefonoTerminaCompanias(String tel) {
		return comr.findByTelefonoContratacionEndingWith(tel);
	}

	@Override
	public List<Seguros> buscarRamoSeguros(String ramo) {
		return sr.findByRamoLikeIgnoreCaseOrderByNumeroPolizaAsc(ramo);
	}

	@Override
	public List<Seguros> buscarFechaInicioSeguros(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
		Date fechaInicio = null;
		try {
			fechaInicio = formato.parse(fecha);
		} catch (ParseException e) {
			LOG.warn(e);
		}
		return sr.findByFechaInicioBeforeOrderByNumeroPolizaDesc(fechaInicio);
	}

	@Override
	public List<Siniestros> buscarAceptadoSiniestros(Character aceptado) {
		return sir.findByAceptadoLikeOrderByIdSiniestroAsc(aceptado);
	}

	@Override
	public List<Siniestros> buscarFechaSiniestro(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
		Date fechaSiniestro = null;
		try {
			fechaSiniestro = formato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sir.findByFechaSiniestroAfterOrderByIdSiniestroAsc(fechaSiniestro);
	}

	@Override
	public Page<Clientes> verNumViaClientes(Integer num, Integer pag) {
		Pageable paginador = PageRequest.of(pag, 3);
		return cr.buscarNumViaPaginado(paginador, num);
	}

	@Override
	public Page<Peritos> verApellidos(String ape, Integer pag) {
		Pageable paginador = PageRequest.of(pag, 3);
		return pr.buscarApellidosPaginado(paginador, ape);
	}

	@Override
	public Page<CompaniasSeguros> verSeguros(Integer num, Integer pag) {
		Pageable paginador = PageRequest.of(pag, 3);
		return csr.buscarPorSeguros(paginador, num);
	}

	@Override
	public SalidaFuncionDTO ejectuarFuncionProm(String info, int num1, double num2) {
		return sg.funcionPromedio(info, num1, num2);
	}

	@Override
	public SalidaProcedimientoDTO ejectuarProcedimiento(String info, int num1) {
		return sg.procedimientoContadorSeguros(info, num1);
	}
	
	
}
