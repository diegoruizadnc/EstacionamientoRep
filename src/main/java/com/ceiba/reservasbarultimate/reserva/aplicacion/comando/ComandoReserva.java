package com.ceiba.reservasbarultimate.reserva.aplicacion.comando;

import java.util.Date;

import lombok.Getter;

@Getter
public class ComandoReserva {

	public ComandoReserva() {

	}
		private Integer idMesa;
		private Long idUsuario;
		private Integer cantidadPersonas;
		
		public ComandoReserva( Integer idMesa, Long idUsuario,Integer cantidadPersonas) {
			this.idMesa = idMesa;
			this.idUsuario = idUsuario;
			this.cantidadPersonas = cantidadPersonas;
		}
	
	
	

}
