package com.ceiba.reservasbarultimate.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

public class ReservaTest {
	
	public ReservaTest() {
		
	}
	
	@Test
	public void crearReservaNumeroMesaNulo() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		Reserva reserva = new Reserva(null,10302l,fecha,5,180000l);
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	public void crearReservaNumeroMesaMayorNueve() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		Reserva reserva = new Reserva(10,10302l,fecha,5,180000l);
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	public void crearReservaNumeroMesaNegativo() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		Reserva reserva = new Reserva(-6,10302l,fecha,5,180000l);
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	public void crearReservaDiaNoValido() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		Reserva reserva = new Reserva(1,10302l,fecha,5,180000l);
		//assert
		}catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado",e.getMessage() );
		}
		
		
	}
	
	@Test
	public void crearReservaFechaNulo() throws Exception{
		//arrange
		Date fecha = null;
		//act
		try {
		Reserva reserva = new Reserva(1,10302l,null,5,180000l);
		//assert
		}catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado",e.getMessage() );
		}
		
		
	}

}
