package com.ceiba.reservasbarultimate.reserva.dominio.excepciones;

public class CamposReservaExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = -2829348196725436242L;

	public CamposReservaExcepcion(String mensaje){
		super(mensaje);
	}

}
