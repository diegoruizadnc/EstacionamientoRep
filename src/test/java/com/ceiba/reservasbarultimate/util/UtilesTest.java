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
	 void ElValorEsNumerico() {
		//arrange
		 String cadena =  "6";
		//act
		 Boolean resultado = Utiles.esNumerico(cadena);
		 //assert
		 assertEquals(true,resultado);
		 
	 }
	 
	 @Test
	 void ElValorNoEsNumerico() {
		//arrange
		 String cadena =  "a";
		//act
		 Boolean resultado = Utiles.esNumerico(cadena);
		 //assert
		 assertEquals(false,resultado);
		 
	 }
	 
	 @Test
	 void ElValorNoEsNulo() {
		//arrange
		 String cadena =  null;
		//act
		 Boolean resultado = Utiles.esNumerico(cadena);
		 //assert
		 assertEquals(false,resultado);
		 
	 }
	 
	 

}
