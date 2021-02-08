package com.ceiba.reservasbarultimate.reserva.aplicacion.comando;

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

		public Integer getIdMesa() {
			return idMesa;
		}


		public Long getIdUsuario() {
			return idUsuario;
		}


		public Integer getCantidadPersonas() {
			return cantidadPersonas;
		}

	

}
