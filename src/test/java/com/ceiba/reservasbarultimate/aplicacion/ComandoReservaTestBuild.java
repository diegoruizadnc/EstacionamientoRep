package com.ceiba.reservasbarultimate.aplicacion;

import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;

public class ComandoReservaTestBuild {
	
	private Integer idMesa;
	private Long idUsuario;
	private Integer cantidadPersonas;
	
	public ComandoReservaTestBuild() {
		
		idMesa = 1;
		idUsuario = 34567899l;
		cantidadPersonas = 4;

	}
	
	 public ComandoReserva build() {
	        return new ComandoReserva(idMesa,idUsuario,cantidadPersonas);
	    }

}
