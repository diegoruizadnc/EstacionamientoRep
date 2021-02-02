package com.ceiba.reservasbarultimate.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

class UtilesTest {
	 
	 UtilesTest(){
		 
	 }
	 
	 // Mesa 1
	 
	 @Test
	 void CalcularValorReservaMesa1DiaSabado() {
		//arrange
		 Integer numerMesa = 1;
		 LocalDate localDate  = LocalDate.of(2021, 01, 29); // sabado
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(200000l,resultado);
		 
	 }
	 
	 
	 @Test
	 void CalcularValorReservaMesa1DiaViernes() {
		//arrange
		 Integer numerMesa = 1;
		 LocalDate localDate  = LocalDate.of(2021, 01, 28); // viernes
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(190000l,resultado);
		 
	 }
	 
	 @Test
	 void CalcularValorReservaMesa1DiaJueves() {
		//arrange
		 Integer numerMesa = 1;
		 LocalDate localDate  = LocalDate.of(2021, 01, 27); // jueves
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(180000l,resultado);
		 
	 }
	 
	 @Test
	 void CalcularValorReservaMesa1DiaMiercoles() {
		//arrange
		 Integer numerMesa = 1;
		 LocalDate localDate  = LocalDate.of(2021, 01, 26); // miercoles
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(170000l,resultado);
		 
	 }
	 
	 
	 
	 // Mesa2
	 
	 @Test
	 void CalcularValorReservaMesa2DiaSabado() {
		//arrange
		 Integer numerMesa = 2;
		 LocalDate localDate  = LocalDate.of(2021, 01, 29); // sabado
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(200000l,resultado);
		 
	 }
	 
	 
	 @Test
	 void CalcularValorReservaMesa2DiaViernes() {
		//arrange
		 Integer numerMesa = 2;
		 LocalDate localDate  = LocalDate.of(2021, 01, 28); // viernes
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(190000l,resultado);
		 
	 }
	 
	 @Test
	 void CalcularValorReservaMesa2DiaJueves() {
		//arrange
		 Integer numerMesa = 2;
		 LocalDate localDate  = LocalDate.of(2021, 01, 27); // jueves
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(180000l,resultado);
		 
	 }
	 
	 @Test
	 void CalcularValorReservaMesa2DiaMiercoles() {
		//arrange
		 Integer numerMesa = 2;
		 LocalDate localDate  = LocalDate.of(2021, 01, 26); // miercoles
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Long resultado = mockedUtiles.calcularValorReserva(fecha,numerMesa);
		 //assert
		 assertEquals(170000l,resultado);
		 
	 }
	 
	 
	 @Test
	 void DiaDeLaSEmanaCorrecto() {
		//arrange
			LocalDate localDate  = LocalDate.of(2021, 01, 25);
		    Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 int resultado = mockedUtiles.obtenerDiaSemana(fecha)-1;
		 //assert
		 assertEquals(1,resultado);
		 
	 }
	 
	 @Test
	 void DiaDeLaSEmanaInCorrecto() {
		//arrange
			LocalDate localDate  = LocalDate.of(2021, 01, 29);
		    Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 int resultado = mockedUtiles.obtenerDiaSemana(fecha)-1;
		 //assert
		 assertEquals(5,resultado);
		 
		 
	 }
	 
	 @Test
	 void ElValorEsNumerico() {
		//arrange
		 String cadena =  "6";
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		Boolean resultado = mockedUtiles.esNumerico(cadena);
		 //assert
		 assertEquals(true,resultado);
		 
	 }
	 
	 @Test
	 void ElValorNoEsNumerico() {
		//arrange
		 String cadena =  "a";
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		 Boolean resultado = mockedUtiles.esNumerico(cadena);
		 //assert
		 assertEquals(false,resultado);
		 
	 }
	 
	 @Test
	 void ElValorNoEsNulo() {
		//arrange
		 String cadena =  null;
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		 Boolean resultado = mockedUtiles.esNumerico(cadena);
		 //assert
		 assertEquals(false,resultado);
		 
	 }
	 
	 

}
