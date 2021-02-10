package com.ceiba.reservasbarultimate.comun.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

 class UtilesManejoCadenasTest {
	
	
	@Test
	void cadenaNoValidaNoSeAjustaMaximoCaracteresBordeTest() {
		// arrange
	    String cadena = "12345678";
	    Long max = 7l;
		// act
		Boolean esCadenaValida = UtilesManejoCadenas.validaMaxCaracteres(cadena, max);
		// assert
		assertEquals(false, esCadenaValida);

	}
	
	@Test
	void cadenaValidaSeAjustaMaximoCaracteresBordeTest() {
		// arrange
	    String cadena = "123456";
	    Long max = 6l;
		// act
		Boolean esCadenaValida = UtilesManejoCadenas.validaMaxCaracteres(cadena, max);
		// assert
		assertEquals(true, esCadenaValida);

	}
	
	
	@Test
	void cadenaNoValidaNoSeAjustaMinimoCaracteresBordeTest() {
		// arrange
	    String cadena = "123456";
	    Long min = 5l;
		// act
		Boolean esCadenaValida = UtilesManejoCadenas.validaMaxCaracteres(cadena, min);
		// assert
		assertEquals(false, esCadenaValida);

	}
	
	@Test
	void cadenaValidaSeAjustaMinimoCaracteresBordeTest() {
		// arrange
	    String cadena = "123456";
	    Long min = 6l;
		// act
		Boolean esCadenaValida = UtilesManejoCadenas.validaMaxCaracteres(cadena, min);
		// assert
		assertEquals(true, esCadenaValida);

	}
	

	
	

}
