package com.ceiba.reservasbarultimate.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

public class ReservaTest {
	
	public ReservaTest() {
		
	}
	
	@Test
	public void crearReserva() throws Exception{
		
		Date fecha = new Date();
		try {
		Reserva reserva = new Reserva(1,10302l,fecha,5,180000l);
		}catch (Exception e) {
			assertEquals(e.getMessage(), "error, Solo puede hacer las reservas de miercoles a sabado");
		}
		
		
	}

}
