package com.ceiba.reservasbarultimate.reserva.dominio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.ValidadorCampos;

@RunWith(SpringRunner.class)
public class ValidadorCamposTest {

	@Mock
	ValidadorCampos validadorCampos;

	@Test
	public void validarCalculoDiaSemana() {

		// arrange

		Date fechaReserva = new Date();
		int diaPrueba = 1; // Es Lunes
		int diaReal;

		// act

		diaReal = validadorCampos.obtenerDiaSemana(fechaReserva);

		// assert
		//assertTrue(diaReal == diaPrueba);
		Assert.assertEquals(diaReal, diaPrueba);

	}
}
