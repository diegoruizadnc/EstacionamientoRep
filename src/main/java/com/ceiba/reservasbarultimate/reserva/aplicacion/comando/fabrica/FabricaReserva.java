package com.ceiba.reservasbarultimate.reserva.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

@Component
public class FabricaReserva {

	public Reserva crearReserva(ComandoReserva comandoReserva){

		return new Reserva(comandoReserva.getIdMesa(), comandoReserva.getIdUsuario(),
				comandoReserva.getCantidadPersonas());
	}
}
