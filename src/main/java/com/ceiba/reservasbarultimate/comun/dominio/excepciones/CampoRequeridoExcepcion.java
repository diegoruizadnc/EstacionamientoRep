package com.ceiba.reservasbarultimate.comun.dominio.excepciones;

public class CampoRequeridoExcepcion extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2425898890398014729L;

	public CampoRequeridoExcepcion(String mensaje){
		super(mensaje);
	}
}
