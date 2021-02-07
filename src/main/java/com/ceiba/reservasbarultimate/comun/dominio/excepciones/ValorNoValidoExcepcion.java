package com.ceiba.reservasbarultimate.comun.dominio.excepciones;

public class ValorNoValidoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorNoValidoExcepcion(String mensaje) {
		super(mensaje);
	}
	
}
