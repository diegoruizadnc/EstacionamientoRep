package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.reservasbarultimate.mesa.builders.MesaDtoTestDataBuilder;
import com.ceiba.reservasbarultimate.mesa.builders.MesaTestDataBuilder;
import com.ceiba.reservasbarultimate.mesa.dominio.ConversorMesaDtoAMesa;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.repositorio.MesaRepositorio;

class ServicioCambiarDisponibilidadMesaTest {

	@Test
	void cambioDisponibilidadMesaAFalso() {

		// arrange
		MesaDto mesaDto = new MesaDtoTestDataBuilder().conEstaDisponible(true).build();
		Mesa mesa = new MesaTestDataBuilder().conEstaDisponible(true).build();

		ConversorMesaDtoAMesa conversorMesaDtoAMesa = Mockito.mock(ConversorMesaDtoAMesa.class);
		Mockito.when(conversorMesaDtoAMesa.ejecutar(mesaDto)).thenReturn(mesa);

		MesaRepositorio mesaRepositorio = Mockito.mock(MesaRepositorio.class);
		Mockito.when(mesaRepositorio.actualizar(mesa)).thenReturn(true);

		ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa = new ServicioCambiarDisponibilidadMesa(
				mesaRepositorio, conversorMesaDtoAMesa);

		// act
		Boolean realizoCambioDisponibilidad = servicioCambiarDisponibilidadMesa.ejecutar(mesaDto);

		// assert
		assertEquals(true, realizoCambioDisponibilidad);

	}

	@Test
	void laMesaQueSeIntentaReservarNoEstaDisponibleTest() {

		// arrange
		MesaDto mesaDto = new MesaDtoTestDataBuilder().conEstaDisponible(false).build();
		Mesa mesa = new MesaTestDataBuilder().conEstaDisponible(false).build();

		ConversorMesaDtoAMesa conversorMesaDtoAMesa = Mockito.mock(ConversorMesaDtoAMesa.class);
		Mockito.when(conversorMesaDtoAMesa.ejecutar(mesaDto)).thenReturn(mesa);

		MesaRepositorio mesaRepositorio = Mockito.mock(MesaRepositorio.class);
		Mockito.when(mesaRepositorio.actualizar(mesa)).thenReturn(true);

		ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa = new ServicioCambiarDisponibilidadMesa(
				mesaRepositorio, conversorMesaDtoAMesa);

		// act

		try {

			Boolean realizoCambioDisponibilidad = servicioCambiarDisponibilidadMesa.ejecutar(mesaDto);

		} catch (Exception e) {
			// assert
			assertEquals("Lo sentimos, La mesa que intentas reservar NO esta disponible", e.getMessage());
		}

	}

}
