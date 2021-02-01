package com.ceiba.reservasbarultimate.reserva.aplicacion.comando.manejador;



import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.fabrica.FabricaReserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.servicio.ServicioCrearReserva;

@Component
public class ManejadorCrearReserva {
	
	private final ServicioCrearReserva servicioCrearReserva;
	private final FabricaReserva fabricaReserva;
	
	public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva,
			FabricaReserva fabricaReserva){
		this.servicioCrearReserva=servicioCrearReserva;
		this.fabricaReserva=fabricaReserva;
	}
	
	@Transactional
	public ReservaDto ejecutar(ComandoReserva comandoReserva){
		Reserva reserva=fabricaReserva.crearReserva(comandoReserva);
		return servicioCrearReserva.ejecutar(reserva); 
	}

}
