package com.ceiba.reservasbarultimate.util;

import org.junit.jupiter.api.Test;

import com.ceiba.reservasbarultimate.comun.util.Utiles;

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
			LocalDate localDate  = LocalDate.of(2021, 02, 01);
		    Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		int resultado = mockedUtiles.obtenerDiaSemana(fecha);
		 //assert
		 assertEquals(1,resultado);
		 
	 }
	 
	 @Test
	 void DiaDeLaSEmanaInCorrecto() {
		//arrange
			LocalDate localDate  = LocalDate.of(2021, 02, 12);
		    Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		 Utiles  mockedUtiles = mock(Utiles.class);
		 @SuppressWarnings("static-access")
		int resultado = mockedUtiles.obtenerDiaSemana(fecha);
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
