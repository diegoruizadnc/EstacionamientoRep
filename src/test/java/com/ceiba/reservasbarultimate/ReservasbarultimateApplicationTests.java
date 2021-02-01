package com.ceiba.reservasbarultimate;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.ValidadorCampos;

@SpringBootTest
class ReservasbarultimateApplicationTests {
	

	@Test
	void contextLoads() {
	}
	
	
	@Test
	 void validarCalculoDiaSemana() {

		// arrange

		Date fechaReserva = new Date();
		int diaPrueba = 1; // Es Lunes
		int diaReal;

		// act

		diaReal = ValidadorCampos.obtenerDiaSemana(fechaReserva);

		// assert
		assertTrue(diaReal == diaPrueba);
	

	}

}
