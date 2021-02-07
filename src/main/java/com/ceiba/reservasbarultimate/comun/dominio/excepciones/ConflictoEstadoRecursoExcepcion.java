package com.ceiba.reservasbarultimate.comun.dominio.excepciones;

public class ConflictoEstadoRecursoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConflictoEstadoRecursoExcepcion(String mensaje) {
		super(mensaje);
	}

}
