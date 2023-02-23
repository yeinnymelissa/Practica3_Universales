
package com.practica3.seguni.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class SalidaProcedimientoDTO implements Serializable {
	
	private static final long serialVersionUID = -7133965831454782463L;
	private String info;
	private BigDecimal contador;
	
}
