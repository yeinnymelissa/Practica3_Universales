
package com.practica3.seguni.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class SalidaFuncionDTO implements Serializable {

	private static final long serialVersionUID = 3471345066424054640L;
	private String info;
	private String salida;
	private BigDecimal resultado;
	
}
