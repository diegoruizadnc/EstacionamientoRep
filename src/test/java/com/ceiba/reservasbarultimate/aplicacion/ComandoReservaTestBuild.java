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

	public ComandoReservaTestBuild conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}
	
	public ComandoReservaTestBuild conIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ComandoReservaTestBuild conCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
		return this;
	}

	public ComandoReserva build() {
		return new ComandoReserva(idMesa, idUsuario, cantidadPersonas);
	}
	
	

}
