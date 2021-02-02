package com.ceiba.reservasbarultimate.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilesTest {
	 
	 UtilesTest(){
		 
	 }
	 
	 @Test
	 void ElValorEsNumerico() {
		 
		 Boolean resultado = Utiles.esNumerico("6");
		 assertEquals(true,resultado);
		 
	 }

}
