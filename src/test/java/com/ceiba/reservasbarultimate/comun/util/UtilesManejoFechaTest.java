package com.ceiba.reservasbarultimate.comun.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

 class UtilesManejoFechaTest {
	
	UtilesManejoFechaTest(){
		
	}
	
	
	@Test
	void DiaDeLaSemanaLunes() {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 01); // Lunes
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		int resultado = UtilesManejoFechas.obtenerDiaSemana(fecha);
		// assert
		assertEquals(1, resultado);

	}
	
	@Test
	void DiaDeLaSemanaMiercoles() {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 03); // Lunes
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		int resultado = UtilesManejoFechas.obtenerDiaSemana(fecha);
		// assert
		assertEquals(3, resultado);

	}

	@Test
	void DiaDeLaSemanaViernes() {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 12);
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		int resultado = UtilesManejoFechas.obtenerDiaSemana(fecha);
		// assert
		assertEquals(5, resultado);

	}
	
	@Test
	void DiaDeLaSemanaSabado() {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 13);
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		int resultado = UtilesManejoFechas.obtenerDiaSemana(fecha);
		// assert
		assertEquals(6, resultado);

	}

}
