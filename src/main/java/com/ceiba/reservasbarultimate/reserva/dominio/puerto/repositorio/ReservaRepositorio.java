package com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

public interface ReservaRepositorio {
	
	ReservaDto crear(Reserva reserva);

}
