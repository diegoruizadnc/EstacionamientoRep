package com.ceiba.reservasbarultimate.reserva.builders;

import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;

public class ComandoReservaTestDataBuilder {
	
	private Integer idMesa;
	private Long idUsuario;
	private Integer cantidadPersonas;

	public ComandoReservaTestDataBuilder() {

		idMesa = 1;
		idUsuario = 34567899l;
		cantidadPersonas = 4;

	}

	public ComandoReservaTestDataBuilder conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}
	
	public ComandoReservaTestDataBuilder conIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ComandoReservaTestDataBuilder conCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
		return this;
	}

	public ComandoReserva build() {
		return new ComandoReserva(idMesa, idUsuario, cantidadPersonas);
	}

}
