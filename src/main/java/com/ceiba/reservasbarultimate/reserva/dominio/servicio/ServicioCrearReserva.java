package com.ceiba.reservasbarultimate.reserva.dominio.servicio;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;

@Component
public class ServicioCrearReserva {
	
	private final ReservaRepositorio reservaRepositorio;
	
	
	
	public ServicioCrearReserva(ReservaRepositorio reservaRepositorio){
		this.reservaRepositorio=reservaRepositorio;
	}
	
	public ReservaDto ejecutar(Reserva reserva){
        
		// Verifica  si la mesa esta diponible y si los esta sigue la siguenite parte del codigo:
		ReservaDto reservaDto=null;
		reservaDto=reservaRepositorio.crear(reserva);
		return reservaDto;
		
		}

}
