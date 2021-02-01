package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones;

public class CampoRequeridoExcepcion extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2425898890398014729L;

	public CampoRequeridoExcepcion(String mensaje){
		super(mensaje);
	}
}
