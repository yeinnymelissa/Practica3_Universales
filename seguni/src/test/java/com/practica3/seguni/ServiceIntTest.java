package com.practica3.seguni;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.practica3.seguni.dto.ClientesDTO;
import com.practica3.seguni.dto.CompaniasDTO;
import com.practica3.seguni.dto.CompaniasSegurosDTO;
import com.practica3.seguni.dto.PeritosDTO;
import com.practica3.seguni.dto.SegurosDTO;
import com.practica3.seguni.dto.SiniestrosDTO;
import entity.Clientes;
import entity.Companias;
import entity.CompaniasSeguros;
import entity.Peritos;
import entity.Seguros;
import entity.Siniestros;
import com.practica3.seguni.repository.PeritosRepository;
import com.practica3.seguni.ws.ServiceWS;

@SpringBootTest
class ServiceIntTest {
	private static final Log LOG = LogFactory.getLog(ServiceIntTest.class);
	
	@Autowired
	ServiceWS service;
	
	@Autowired
	PeritosRepository pr;
	
	@Test
	void buscarClientesTest() {
		List<Clientes> clientes = service.buscarClientes();
		assertNotNull(clientes, "No hay clientes.");
	}
	
	@Test 
	void guardarClientesTest() {
		try {
			
			ClientesDTO cli = new ClientesDTO();
			
			cli.setDniCl("2783982680101");
			cli.setNombreCl("Francisco");
			cli.setApellido1("Pereira");
			cli.setApellido2("Andrade");
			cli.setClaseVia("A");
			cli.setNombreVia("Prueba3");
			cli.setNumeroVia(1);
			cli.setCodPostal(342);
			cli.setCiudad("Guatemala");
			cli.setTelefono("56889223");
			cli.setObservaciones("Sin observaciones");
			
			Clientes cliente = service.guardarClientes(cli);
			
			service.eliminarCliente("2783982680101");
			
			assertNotNull(cliente, "Guardar cliente");
			
			
		}catch (Exception e) {
			LOG.error(e.getMessage());
			fail();
		}
	}
	
	@Test 
	void actualizarClientesTest() {
		try {
			
			ClientesDTO cli = new ClientesDTO();
			
			cli.setDniCl("3017261750101");
			cli.setNombreCl("Melissa");
			cli.setApellido1("Catalan");
			cli.setApellido2("de Leon");
			cli.setClaseVia("A");
			cli.setNombreVia("Prueba3");
			cli.setNumeroVia(1);
			cli.setCodPostal(210);
			cli.setCiudad("Guatemala");
			cli.setTelefono("56889223");
			cli.setObservaciones("Sin observaciones");
			
			Clientes cliente = service.guardarClientes(cli);
			
			cli.setDniCl("3017261750101");
			cli.setNombreCl("Yeinny");
			cli.setApellido1("Catalan");
			cli.setApellido2("de León");
			cli.setClaseVia("C");
			cli.setNombreVia("Prueba3");
			cli.setNumeroVia(3);
			cli.setCodPostal(122);
			cli.setCiudad("Guatemala");
			cli.setTelefono("78776545");
			cli.setObservaciones("Pendiente de revisión.");
			service.guardarClientes(cli);
			
			assertNotNull(cliente, "Actualizar cliente");
			
			
		}catch (Exception e) {
			LOG.error(e.getMessage());
			fail();
		}
	}
	
	@Test 
	void eliminarClienteTest() {
		try {
			boolean seElimino = service.eliminarCliente("8765258960101");
			ClientesDTO cli = new ClientesDTO();
			
			cli.setDniCl("8765258960101");
			cli.setNombreCl("Julio");
			cli.setApellido1("Hernandez");
			cli.setApellido2("Monzon");
			cli.setClaseVia("B");
			cli.setNombreVia("Prueba2");
			cli.setNumeroVia(2);
			cli.setCodPostal(310);
			cli.setCiudad("Guatemala");
			cli.setTelefono("89776589");
			cli.setObservaciones("Pendiente de revisión.");
			service.guardarClientes(cli);
			
			assertTrue(seElimino);
			
			
		}catch (Exception e) {
			LOG.error(e.getMessage());
			fail();
		}
	}
	
	@Test
	void buscarSegurosTest() {
		List<Seguros> seguros = service.buscarSeguros();
		assertNotNull(seguros, "No hay seguros.");
	}
	
	@Test 
	void guardarSegurosTest() {
		try {
			
			SegurosDTO seg = new SegurosDTO();
			
			seg.setNumeroPoliza(3);
			seg.setRamo("Vida");
			String fechIni = "05-08-2019";
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
			Date fechaInicio = null;
			try {
				fechaInicio = formato.parse(fechIni);
			} catch (ParseException e) {
				LOG.warn(e);
			}
			seg.setFechaInicio(fechaInicio);
			String fechFin = "05-08-2021";
			Date fechaVencimiento= null;
			try {
				fechaVencimiento = formato.parse(fechFin);
			} catch (ParseException e) {
				LOG.warn(e);
			}
			seg.setFechaVencimiento(fechaVencimiento);
			seg.setCondicionesParticulares("Prima periodica");
			seg.setObservaciones("Sin observaciones");
			seg.setDniCl("4567598760101");
			
			Seguros seguros = service.guardarSeguros(seg);
			
			service.eliminarSeguro(seguros.getNumeroPoliza());
			
			assertNotNull(seguros, "Guardar seguro");
			
			
		}catch (Exception e) {
			LOG.error(e.getMessage());
			fail();
		}
	}
	
	@Test 
	void actualizarSeguroTest() {
		try {
			
			SegurosDTO seg = new SegurosDTO();
			
			seg.setNumeroPoliza(15);
			seg.setRamo("Vida");
			String fechIni = "08-04-2017";
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
			Date fechaInicio = null;
			try {
				fechaInicio = formato.parse(fechIni);
			} catch (ParseException e) {
				LOG.warn(e);
			}
			seg.setFechaInicio(fechaInicio);
			String fechFin = "08-04-2019";
			Date fechaVencimiento= null;
			try {
				fechaVencimiento = formato.parse(fechFin);
			} catch (ParseException e) {
				LOG.warn(e);
			}
			seg.setFechaVencimiento(fechaVencimiento);
			seg.setCondicionesParticulares("Prima");
			seg.setObservaciones("Sin observaciones");
			seg.setDniCl("4567598760101");
			
			Seguros segurosG = service.guardarSeguros(seg);
			
			
			
			seg.setNumeroPoliza(segurosG.getNumeroPoliza());
			seg.setRamo("Vehiculos");
			fechIni = "08-04-2017";
			fechaInicio = null;
			try {
				fechaInicio = formato.parse(fechIni);
			} catch (ParseException e) {
				LOG.warn(e);
			}
			seg.setFechaInicio(fechaInicio);
			fechFin = "08-04-2019";
			fechaVencimiento= null;
			try {
				fechaVencimiento = formato.parse(fechFin);
			} catch (ParseException e) {
				LOG.warn(e);
			}
			seg.setFechaVencimiento(fechaVencimiento);
			seg.setCondicionesParticulares("Prima periodica");
			seg.setObservaciones("Sin observaciones");
			seg.setDniCl("4567598760101");
			Seguros seguros = service.actualizarSeguro(seg);
			
			service.eliminarSeguro(seguros.getNumeroPoliza());
			
			assertNotNull(seguros, "Actualizar seguro");
			
			
		}catch (Exception e) {
			LOG.error(e.getMessage());
			fail();
		}
	}
	
	
	  @Test void eliminarSeguroTest() { 
		  try { 
			  
			  SegurosDTO seg = new SegurosDTO();
				
				seg.setNumeroPoliza(4);
				seg.setRamo("Vehiculos");
				String fechIni = "08-04-2017";
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
				Date fechaInicio = null;
				try {
					fechaInicio = formato.parse(fechIni);
				} catch (ParseException e) {
					LOG.warn(e);
				}
				seg.setFechaInicio(fechaInicio);
				String fechFin = "08-04-2019";
				Date fechaVencimiento= null;
				try {
					fechaVencimiento = formato.parse(fechFin);
				} catch (ParseException e) {
					LOG.warn(e);
				}
				seg.setFechaVencimiento(fechaVencimiento);
				seg.setCondicionesParticulares("Prima periodica");
				seg.setObservaciones("Sin observaciones");
				seg.setDniCl("4567598760101");
				
				Seguros segu = service.guardarSeguros(seg);
				boolean seElimino = service.eliminarSeguro(segu.getNumeroPoliza()); 
			  
				assertTrue(seElimino);
		  
		  
		  }catch (Exception e) { 
			  LOG.error(e.getMessage()); fail(); 
		  } 
	  }
	  
	  @Test
		void buscarSiniestrosTest() {
			List<Siniestros> siniestros = service.buscarSiniestros();
			assertNotNull(siniestros, "No hay siniestros.");
		}
	  
	  @Test 
		void guardarSiniestrosTest() {
			try {
				SiniestrosDTO sin = new SiniestrosDTO();
				String fechIni = "05-08-2019";
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
				Date fechaInicio = null;
				try {
					fechaInicio = formato.parse(fechIni);
				} catch (ParseException e) {
					LOG.warn(e);
				}
				
				sin.setIdSiniestro(2);
				sin.setFechaSiniestro(fechaInicio);
				sin.setCausas("Prueba2");
				sin.setAceptado('Y');
				sin.setIndemnizacion(7800.0);
				sin.setNumeroPoliza(1);
				
				Peritos peri = pr.findByDniPerito("9876467630101");
				sin.setPerito(peri);
				
				Siniestros siniestro = service.guardarSiniestros(sin);
				
				service.eliminarSiniestro(siniestro.getIdSiniestro());
				
				assertNotNull(siniestro, "Guardar siniestro");
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}
	  
	  
	  @Test 
		void actualizarSiniestroTest() {
			try {
				
				SiniestrosDTO sin = new SiniestrosDTO();
				String fechIni = "05-08-2019";
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
				Date fechaInicio = null;
				try {
					fechaInicio = formato.parse(fechIni);
				} catch (ParseException e) {
					LOG.warn(e);
				}
				
				sin.setIdSiniestro(2);
				sin.setFechaSiniestro(fechaInicio);
				sin.setCausas("Prueba2");
				sin.setAceptado('Y');
				sin.setIndemnizacion(7800.0);
				sin.setNumeroPoliza(1);
				
				Peritos peri = pr.findByDniPerito("9876467630101");
				sin.setPerito(peri);
				
				Siniestros siniestroG = service.guardarSiniestros(sin);
				
				
				fechIni = "04-10-2019";
				fechaInicio = null;
				try {
					fechaInicio = formato.parse(fechIni);
				} catch (ParseException e) {
					LOG.warn(e);
				}
				
				sin.setIdSiniestro(siniestroG.getIdSiniestro());
				sin.setFechaSiniestro(fechaInicio);
				sin.setCausas("Prueba2");
				sin.setAceptado('Y');
				sin.setIndemnizacion(7300.0);
				sin.setNumeroPoliza(1);
				
				Peritos periT = pr.findByDniPerito("9876467630101");
				sin.setPerito(periT);
				
				Siniestros siniestro = service.actualizarSiniestro(sin);
				
				service.eliminarSiniestro(siniestro.getIdSiniestro());
				
				assertNotNull(siniestro, "Actualizar siniestro");
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}
		
		
		  @Test void eliminarSiniestroTest() { 
			  try { 
				  
				  SiniestrosDTO sin = new SiniestrosDTO();
					String fechIni = "05-08-2019";
					SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
					Date fechaInicio = null;
					try {
						fechaInicio = formato.parse(fechIni);
					} catch (ParseException e) {
						LOG.warn(e);
					}
					
					sin.setIdSiniestro(2);
					sin.setFechaSiniestro(fechaInicio);
					sin.setCausas("Prueba2");
					sin.setAceptado('Y');
					sin.setIndemnizacion(7800.0);
					sin.setNumeroPoliza(1);
					
					Peritos peri = pr.findByDniPerito("9876467630101");
					sin.setPerito(peri);
					
					Siniestros siniestroG = service.guardarSiniestros(sin);
					boolean seElimino = service.eliminarSiniestro(siniestroG.getIdSiniestro()); 
				  
					assertTrue(seElimino);
			  
			  
			  }catch (Exception e) { 
				  LOG.error(e.getMessage()); fail(); 
			  } 
		  }
		  
		  @Test
			void buscarCompaniaSegurosTest() {
				List<CompaniasSeguros> comSeg = service.buscarCompaniaSeguros();
				assertNotNull(comSeg, "No hay relaciones entre companias y seguros.");
			}
		  
		  @Test 
			void guardarCompaniaSegurosTest() {
				try {
					CompaniasSegurosDTO comSeguros = new CompaniasSegurosDTO();
					
					comSeguros.setId(3);
					comSeguros.setNombreCompania("Seguritos");
					comSeguros.setNumeroPoliza(1);
					
					CompaniasSeguros comSeg = service.guardarCompaniaSeguros(comSeguros);
					
					service.eliminarCompaniaSeguro(comSeg.getId());
					
					assertNotNull(comSeg, "Guardar relacion companias y seguros");
					
					
				}catch (Exception e) {
					LOG.error(e.getMessage());
					fail();
				}
			}
		  
		  
		  @Test 
			void actualizarCompaniaSeguroTest() {
				try {
					
					CompaniasSegurosDTO comSeguros = new CompaniasSegurosDTO();
					
					comSeguros.setId(3);
					comSeguros.setNombreCompania("Seguritos");
					comSeguros.setNumeroPoliza(1);
					
					CompaniasSeguros comSegG = service.guardarCompaniaSeguros(comSeguros);
					
					
					comSeguros.setId(comSegG.getId());
					comSeguros.setNombreCompania("Universales");
					comSeguros.setNumeroPoliza(2);
					
					CompaniasSeguros comSeg = service.actualizarCompaniaSeguro(comSeguros);
					
					service.eliminarCompaniaSeguro(comSeguros.getId());
					
					assertNotNull(comSeg, "Actualizar relacion compania y seguros");
					
					
				}catch (Exception e) {
					LOG.error(e.getMessage());
					fail();
				}
			}
			
			
		  @Test void eliminarCompaniaSeguroTest() { 
			  try { 
				  
				  CompaniasSegurosDTO comSeguros = new CompaniasSegurosDTO();
					
					comSeguros.setId(3);
					comSeguros.setNombreCompania("Seguritos");
					comSeguros.setNumeroPoliza(1);
					
					CompaniasSeguros comSeg = service.guardarCompaniaSeguros(comSeguros);
					
					boolean seElimino = service.eliminarCompaniaSeguro(comSeg.getId()); 
				  
					assertTrue(seElimino);
			  
			  
			  }catch (Exception e) { 
				  LOG.error(e.getMessage()); fail(); 
			  } 
		  }
		 
		@Test
		void buscarCompaniasTest() {
			List<Companias> companias = service.buscarCompanias();
			assertNotNull(companias, "No hay companias.");
		}
		
		@Test 
		void guardarCompaniasTest() {
			try {
				
				CompaniasDTO compa = new CompaniasDTO();
				
				compa.setNombreCompania("Seguros G&T");
				compa.setClaseVia("Prueba1");
				compa.setNombreVia("PruebaVia1");
				compa.setNumeroVia(3);
				compa.setCodPostal(123);
				compa.setTelefonoContratacion("67659823");
				compa.setTelefonoSiniestros("89997651");
				compa.setNotas("Sin notas");
				
				Companias compania = service.guardarCompanias(compa);
				
				service.eliminarCompanias("Seguros G&T");
				
				assertNotNull(compania, "Guardar compania");
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}
			
		@Test 
		void actualizarCompaniaTest() {
			try {
				
				CompaniasDTO compa = new CompaniasDTO();
				
				compa.setNombreCompania("Seguros Test");
				compa.setClaseVia("Prueba1");
				compa.setNombreVia("PruebaVia1");
				compa.setNumeroVia(3);
				compa.setCodPostal(123);
				compa.setTelefonoContratacion("67659823");
				compa.setTelefonoSiniestros("89997651");
				compa.setNotas("Sin notas");
				
				Companias compani = service.guardarCompanias(compa);
				
				compa.setNombreCompania("Seguros Test");
				compa.setClaseVia("C");
				compa.setNombreVia("Prueb3");
				compa.setNumeroVia(2);
				compa.setCodPostal(167);
				compa.setTelefonoContratacion("87675432");
				compa.setTelefonoSiniestros("98097656");
				compa.setNotas("Sin notas.");
				service.guardarCompanias(compa);
				
				assertNotNull(compani, "Actualizar compania");
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}
			
		@Test 
		void eliminarCompaniasTest() {
			try {
				boolean seElimino = service.eliminarCompanias("Seguros Test");
				CompaniasDTO compa = new CompaniasDTO();
				
				compa.setNombreCompania("Seguros Test");
				compa.setClaseVia("C");
				compa.setNombreVia("Prueb3");
				compa.setNumeroVia(2);
				compa.setCodPostal(167);
				compa.setTelefonoContratacion("87675432");
				compa.setTelefonoSiniestros("98097656");
				compa.setNotas("Sin notas.");
				service.guardarCompanias(compa);
				
				assertTrue(seElimino);
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}  
		
		@Test
		void buscarPeritosTest() {
			List<Peritos> peritos = service.buscarPeritos();
			assertNotNull(peritos, "No hay peritos.");
		}
		
		@Test 
		void guardarPeritosTest() {
			try {
				
				PeritosDTO peri = new PeritosDTO();

				peri.setDniPerito("9087665630101");
				peri.setNombrePerito("Roberto");
				peri.setApellidoPerito1("Avalos");
				peri.setApellidoPerito2("Mendoza");
				peri.setTelefonoContacto("89876754");
				peri.setTelefonoOficina("14567524");
				peri.setClaseVia("A");
				peri.setNombreVia("Prueba2");
				peri.setNumeroVia(2);
				peri.setCodPostal(110);
				peri.setCiudad("Guatemala");
				
				Peritos perito = service.guardarPeritos(peri);
				
				service.eliminarPeritos("9087665630101");
				
				assertNotNull(perito, "Guardar perito");
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}
			
		@Test 
		void actualizarPeritosTest() {
			try {
				
				PeritosDTO peri = new PeritosDTO();

				peri.setDniPerito("8724356750101");
				peri.setNombrePerito("Karla");
				peri.setApellidoPerito1("Sanchez");
				peri.setApellidoPerito2("Ramirez");
				peri.setTelefonoContacto("88778887");
				peri.setTelefonoOficina("14567524");
				peri.setClaseVia("A");
				peri.setNombreVia("Prueba2");
				peri.setNumeroVia(2);
				peri.setCodPostal(335);
				peri.setCiudad("Guatemala");
				
				Peritos perito = service.guardarPeritos(peri);
				
				peri.setDniPerito("8724356750101");
				peri.setNombrePerito("Viviana");
				peri.setApellidoPerito1("Garcia");
				peri.setApellidoPerito2("Fernandez");
				peri.setTelefonoContacto("78654545");
				peri.setTelefonoOficina("78907613");
				peri.setClaseVia("A");
				peri.setNombreVia("Prueba2");
				peri.setNumeroVia(4);
				peri.setCodPostal(125);
				peri.setCiudad("Guatemala");
				service.guardarPeritos(peri);
				
				assertNotNull(perito, "Actualizar perito");
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}
			
		@Test 
		void eliminarPeritosTest() {
			try {
				boolean seElimino = service.eliminarPeritos("8724356750101");
				PeritosDTO peri = new PeritosDTO();
				
				peri.setDniPerito("8724356750101");
				peri.setNombrePerito("Viviana");
				peri.setApellidoPerito1("Garcia");
				peri.setApellidoPerito2("Fernandez");
				peri.setTelefonoContacto("78654545");
				peri.setTelefonoOficina("78907613");
				peri.setClaseVia("A");
				peri.setNombreVia("Prueba2");
				peri.setNumeroVia(4);
				peri.setCodPostal(125);
				peri.setCiudad("Guatemala");
				service.guardarPeritos(peri);
				
				assertTrue(seElimino);
				
				
			}catch (Exception e) {
				LOG.error(e.getMessage());
				fail();
			}
		}  
		
		@Test
		void buscarInicioCiudadClientesTest() {
			List<Clientes> inicio = service.buscarInicioCiudadClientes("Gua");
			assertNotNull(inicio, "No hay ciudades que inicien con esos caracteres.");
		}
		
		@Test
		void buscarCodPostalClientesTest() {
			List<Clientes> inicio = service.buscarCodPostalClientes(310);
			assertNotNull(inicio, "No hay clientes que se encuentren en el codigo postal indicado.");
		}
		
		@Test
		void buscarInicioNombrePeritosTest() {
			List<Peritos> inicio = service.buscarInicioNombrePeritos("Viv");
			assertNotNull(inicio, "No hay peritos que tengan un nombre que inicien con los caracteres propuestos.");
		}
		
		@Test
		void buscarTelefonoPeritosTest() {
			List<Peritos> inicio = service.buscarTelefonoPeritos("7");
			assertNotNull(inicio, "No hay peritos que tengan un numero de telefono que empiece así.");
		}
		
		@Test
		void buscarNumeroViaMayorCompaniasTest() {
			List<Companias> inicio = service.buscarNumeroViaMayorCompanias(1);
			assertNotNull(inicio, "No hay companias que tengan un numero mayor de via que el propuesto.");
		}
		
		@Test
		void buscarTelefonoTerminaCompaniasTest() {
			List<Companias> inicio = service.buscarTelefonoTerminaCompanias("4");
			assertNotNull(inicio, "No hay companias que tengan un numero que terminen con los caracteres propuestos.");
		}
		
		@Test
		void buscarRamoSegurosTest() {
			List<Seguros> inicio = service.buscarRamoSeguros("vida");
			assertNotNull(inicio, "No ha seguros que tengan ese tipo de ramo.");
		}
		
		@Test
		void buscarFechaInicioSegurosTest() {
			List<Seguros> inicio = service.buscarFechaInicioSeguros("10-07-2021");
			assertNotNull(inicio, "No ha seguros que tengan una fecha de inicio anterior a la fecha propuesta.");
		}
		
		@Test
		void buscarAceptadoSiniestrosTest() {
			List<Siniestros> inicio = service.buscarAceptadoSiniestros('Y');
			assertNotNull(inicio, "No hay siniestros que hayan sido aceptados.");
		}
		
		@Test
		void buscarFechaSiniestroTest() {
			List<Siniestros> inicio = service.buscarFechaSiniestro("06-09-2016");
			assertNotNull(inicio, "No hay siniestros que tengan una fecha mayor a la fecha propuesta.");
		}
		
		@Test
		void verNumViaClientesTest() {
			Page<Clientes> inicio = service.verNumViaClientes(1, 0);
			assertNotNull(inicio, "No hay clientes que tengan un numero de via mayor al numero propuesto.");
		}
		
		@Test
		void verApellidosTest() {
			Page<Peritos> inicio = service.verApellidos("Di", 0);
			assertNotNull(inicio, "No peritos que tengan un apellido que empiece con los caracteres propuestos.");
		}
		
		@Test
		void verSegurosTest() {
			Page<CompaniasSeguros> inicio = service.verSeguros(1, 0);
			assertNotNull(inicio, "No existe una relacion de compania y seguros que tengan ese numero de seguro.");
		}
			
			
}
