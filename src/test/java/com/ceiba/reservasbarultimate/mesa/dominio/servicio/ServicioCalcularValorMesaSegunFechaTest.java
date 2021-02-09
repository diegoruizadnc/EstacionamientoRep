package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioCalcularValorMesaSegunFechaTest {

	ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy;

	@BeforeEach
	void prepararPrueba() {

		servicioCalcularValorMesaHoy = new ServicioCalcularValorMesaHoy();
	}

	// Mesa 1

	@Test
	void calcularValorReservaMesa1DiaSabado() {
		// arrange
		Integer numerMesa = 1;
		LocalDate localDate = LocalDate.of(2021, 02, 13); // sabado
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(200000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa1DiaViernes() {
		// arrange
		Integer numerMesa = 1;
		LocalDate localDate = LocalDate.of(2021, 02, 12); // viernes
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(190000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa1DiaJueves() {
		// arrange
		Integer numerMesa = 1;
		LocalDate localDate = LocalDate.of(2021, 02, 11); // jueves
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(180000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa1DiaMiercoles() {
		// arrange
		Integer numerMesa = 1;
		LocalDate localDate = LocalDate.of(2021, 02, 10); // miercoles
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(170000l, resultado);

	}

	// Mesa2

	@Test
	void CalcularValorReservaMesa2DiaSabado() {
		// arrange
		Integer numerMesa = 2;
		LocalDate localDate = LocalDate.of(2021, 02, 13); // sabado
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(200000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa2DiaViernes() {
		// arrange
		Integer numerMesa = 2;
		LocalDate localDate = LocalDate.of(2021, 02, 12); // viernes
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(190000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa2DiaJueves() {
		// arrange
		Integer numerMesa = 2;
		LocalDate localDate = LocalDate.of(2021, 02, 11); // jueves
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(180000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa2DiaMiercoles() {
		// arrange
		Integer numerMesa = 2;
		LocalDate localDate = LocalDate.of(2021, 02, 10); // miercoles
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(200000l, fecha);
		// assert
		assertEquals(170000l, resultado);

	}

	// Mesa4

	@Test
	void CalcularValorReservaMesa4DiaSabado() {
		// arrange
		Integer numerMesa = 4;
		LocalDate localDate = LocalDate.of(2021, 02, 13); // sabado
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(150000l, fecha);
		// assert
		assertEquals(150000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa4DiaViernes() {
		// arrange
		Integer numerMesa = 4;
		LocalDate localDate = LocalDate.of(2021, 02, 12); // viernes
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(150000l, fecha);
		// assert
		assertEquals(142500l, resultado);

	}

	@Test
	void CalcularValorReservaMesa4DiaJueves() {
		// arrange
		Integer numerMesa = 4;
		LocalDate localDate = LocalDate.of(2021, 02, 11); // jueves
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(150000l, fecha);
		// assert
		assertEquals(135000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa4DiaMiercoles() {
		// arrange
		Integer numerMesa = 4;
		LocalDate localDate = LocalDate.of(2021, 02, 10); // miercoles
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(150000l, fecha);
		// assert
		assertEquals(127500l, resultado);

	}

	// Mesa 8

	@Test
	void CalcularValorReservaMesa8DiaSabado() {
		// arrange
		Integer numerMesa = 8;
		LocalDate localDate = LocalDate.of(2021, 02, 13); // sabado
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(100000l, fecha);
		// assert
		assertEquals(100000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa8DiaViernes() {
		// arrange
		Integer numerMesa = 8;
		LocalDate localDate = LocalDate.of(2021, 02, 12); // viernes
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(100000l, fecha);
		// assert
		assertEquals(95000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa8DiaJueves() {
		// arrange
		Integer numerMesa = 8;
		LocalDate localDate = LocalDate.of(2021, 02, 11); // jueves
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(100000l, fecha);
		// assert
		assertEquals(90000l, resultado);

	}

	@Test
	void CalcularValorReservaMesa8DiaMiercoles() {
		// arrange
		Integer numerMesa = 8;
		LocalDate localDate = LocalDate.of(2021, 02, 10); // miercoles
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		Long resultado = servicioCalcularValorMesaHoy.ejecutar(100000l, fecha);
		// assert
		assertEquals(85000l, resultado);

	}

}
