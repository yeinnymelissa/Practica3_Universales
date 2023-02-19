package com.practica3.seguni.service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.practica3.seguni.dto.SalidaFuncionDTO;
import com.practica3.seguni.dto.SalidaProcedimientoDTO;


@Service
public class ServicioGeneral {
	@Autowired
	private JdbcTemplate jt;
	
	private static final String RETORNAR = "retorno";
	private static final String INFO = "info";
	private static final String SALIDA = "salida";
	private static final String CONTADOR = "contador";
	
	public SalidaFuncionDTO funcionPromedio(String info, int num1, double num2) {
		SalidaFuncionDTO sfd = new SalidaFuncionDTO();
		SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
		sjc.withCatalogName("paquete")
			.withFunctionName("funcPromedio")
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
					new SqlOutParameter(RETORNAR, Types.NUMERIC)
					,new SqlInOutParameter(INFO, Types.VARCHAR)
					,new SqlParameter("num1",Types.NUMERIC)
					,new SqlParameter("num2",Types.NUMERIC)
					,new SqlOutParameter(SALIDA, Types.VARCHAR));
		SqlParameterSource sps = new MapSqlParameterSource()
			.addValue(INFO, info)
			.addValue("num1", num1)
			.addValue("num2", num2);
		
		Map<String,Object> out = sjc.execute(sps);
		if(out.containsKey(RETORNAR)) {
			sfd.setResultado((BigDecimal)out.get(RETORNAR));
		}
		if(out.containsKey(INFO)) {
			sfd.setInfo(out.get(INFO).toString());
		}
		if(out.containsKey(SALIDA)) {
			sfd.setSalida(out.get(SALIDA).toString());
		}
		return sfd;
	}
	
	public SalidaProcedimientoDTO procedimientoContadorSeguros(String info, int numMayor) {
		SalidaProcedimientoDTO sfd = new SalidaProcedimientoDTO();
		SimpleJdbcCall sjc = new SimpleJdbcCall(jt);
		sjc.withCatalogName("paqueteP")
			.withProcedureName("procClientes")
			.withoutProcedureColumnMetaDataAccess()
			.declareParameters(
					new SqlInOutParameter(INFO, Types.VARCHAR)
					,new SqlParameter("numMayor",Types.NUMERIC)
					,new SqlOutParameter(CONTADOR, Types.NUMERIC));
		SqlParameterSource sps = new MapSqlParameterSource()
			.addValue(INFO, info)
			.addValue("numMayor", numMayor);
		
		Map<String,Object> out = sjc.execute(sps);
		if(out.containsKey(INFO)) {
			sfd.setInfo(out.get(INFO).toString());
		}
		if(out.containsKey(CONTADOR)) {
			sfd.setContador((BigDecimal)out.get(CONTADOR));
		}
		return sfd;
	}
}
