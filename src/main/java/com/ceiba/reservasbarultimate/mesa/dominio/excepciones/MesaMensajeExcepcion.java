package com.ceiba.reservasbarultimate.mesa.dominio.excepciones;

public class MesaMensajeExcepcion extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -829015529026271197L;

	public MesaMensajeExcepcion(String mensaje){
		super(mensaje);
	}

}
