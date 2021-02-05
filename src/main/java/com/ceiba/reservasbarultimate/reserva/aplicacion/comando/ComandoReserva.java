package com.ceiba.reservasbarultimate.reserva.aplicacion.comando;

import java.util.Date;

import lombok.Getter;

@Getter
public class ComandoReserva {

	public ComandoReserva() {

	}
	
	   // private Long idReserva;
		private Integer idMesa;
		private Long idUsuario;
		//private Date fechaReserva;
		private Integer cantidadPersonas;
		//private Long precioReserva;
		
		public ComandoReserva( Integer idMesa, Long idUsuario, Date fechaReserva, Integer cantidadPersonas,
				Long precioReserva) {
			this.idMesa = idMesa;
			this.idUsuario = idUsuario;
			//this.fechaReserva = fechaReserva;
			this.cantidadPersonas = cantidadPersonas;
			//this.precioReserva = precioReserva;
		}
	
	
	

}
