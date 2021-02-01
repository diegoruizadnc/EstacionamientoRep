package com.ceiba.reservasbarultimate.reserva.dominio;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ceiba.reservasbarultimate.reserva.ReservaTestDataBuilder;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.CampoRequeridoExcepcion;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;
import com.ceiba.reservasbarultimate.reserva.dominio.servicio.ServicioCrearReserva;

import static org.junit.Assert.*;

public class ReservaTest {
	

	@InjectMocks
	ServicioCrearReserva servicioCrearReserva;
	@Mock
	ReservaRepositorio reservaRepository;
	@Mock
	CampoRequeridoExcepcion campoRequeridoExcepcion;
	
	@Test
	public void crearReserva(){
		ReservaDto reservaDto= new ReservaDtoTestDataBuilder().build();
		Reserva reserva= new ReservaTestDataBuilder().build();
	    campoRequeridoExcepcion = new CampoRequeridoExcepcion("error, El numero de mesa debe ser un valor entre 1 y 9");
		
		when(reservaRepository.crear(reserva)).thenReturn(reservaDto);
		
		ReservaDto reservaReturned=servicioCrearReserva.ejecutar(reserva);
	//	assertEquals(reservaReturned, campoRequeridoExcepcion); 
	}

}
