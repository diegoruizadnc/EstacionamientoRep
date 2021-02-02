package com.ceiba.reservasbarultimate.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

 class ReservaTest {
	
	public ReservaTest() {
		
	}
	

	
	@Test
	 void crearReservaNumeroMesaNulo() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		// arrange
		Reserva reserva= new ReservaTestDataBuild().conIdMesa(null).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaNumeroMesaMayorNueve() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		Reserva reserva= new ReservaTestDataBuild().conIdMesa(10).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaNumeroMesaNegativo() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		 Reserva reserva= new ReservaTestDataBuild().conIdMesa(-1).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	
		
	
	
	@Test
	 void crearReservaDiaNoValido() throws Exception{
		
		//arrange
		 String sDate1="25/01/2021";  
		 Date fecha=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
		//act
		try { 
			Reserva reserva= new ReservaTestDataBuild().conFechaReserva(fecha).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado",e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaFechaNulo() throws Exception{
		//arrange
		Date fecha = null;
		//act
		try {
			Reserva reserva= new ReservaTestDataBuild().conFechaReserva(fecha).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado",e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaCantidadPersonasNulo() throws Exception{
		//arrange
		Integer cantidadPersonas = 10;
		//act
		try {
			Reserva reserva= new ReservaTestDataBuild().conCantidadPersonas(cantidadPersonas).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, La cantidad de personas por reserva debe estar entre 1 y 5",e.getMessage() );
		}
		
		
	}

}
