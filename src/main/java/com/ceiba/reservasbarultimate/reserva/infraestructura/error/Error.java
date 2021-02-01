package com.ceiba.reservasbarultimate.reserva.infraestructura.error;

import lombok.Getter;

@Getter
public class Error {
	
	private String nombreExcepcion;
	private String mensaje;
	
	public Error(String nombreExcepcion, String mensaje){
		this.nombreExcepcion=nombreExcepcion;
		this.mensaje=mensaje;
	}

}
