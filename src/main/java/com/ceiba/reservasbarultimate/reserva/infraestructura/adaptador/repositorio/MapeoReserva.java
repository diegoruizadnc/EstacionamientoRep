package com.ceiba.reservasbarultimate.reserva.infraestructura.adaptador.repositorio;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.infraestructura.adaptador.persistencia.ReservaPersistente;

public final class MapeoReserva {
	
	private MapeoReserva() {

	}
	
	public static ReservaPersistente convertirReservaAPersistente(Reserva reserva){
		
		ReservaPersistente reservaPersistente=new ReservaPersistente();
		
		reservaPersistente.setIdMesa(reserva.getIdMesa());;
		reservaPersistente.setIdUsuario(reserva.getIdUsuario());
		reservaPersistente.setFechaReserva(reserva.getFechaReserva());;
		reservaPersistente.setCantidadPersonas(reserva.getCantidadPersonas());
		reservaPersistente.setPrecioReserva(reserva.getPrecioReserva());
		
		return reservaPersistente;
	}

}
