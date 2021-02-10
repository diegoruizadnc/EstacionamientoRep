package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.reservasbarultimate.mesa.builders.MesaDtoTestDataBuilder;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;

class ServicioListarMesasDisponiblesTest {

	@Test
	void listaMesasDisponiblesConPrecioHoyTest() {
		// arrange
		Long precioDescuentoHoy = 190000l;
		List<MesaDto> listaMesasDisponibles = new MesaDtoTestDataBuilder().buildListaMesasDto();
		List<MesaDto> listaMesasDisponiblesConPrecioHoy = new MesaDtoTestDataBuilder().buildListaMesasDtoConPrecioHoy();
		MesaDao mesaDao = Mockito.mock(MesaDao.class);
		ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy = Mockito.mock(ServicioCalcularValorMesaHoy.class);
		Mockito.when(mesaDao.listarMesasDisponibles()).thenReturn(listaMesasDisponibles);

		// act
		ServicioListarMesasDidponibles servicioListarMesasDidponibles = new ServicioListarMesasDidponibles(mesaDao,
				servicioCalcularValorMesaHoy);
		List<MesaDto> listaMesasDisponiblesBuscadas = servicioListarMesasDidponibles.ejecutar();
		for (MesaDto mesadto : listaMesasDisponiblesBuscadas) {
			mesadto.setPrecioConDescuentoHoy(precioDescuentoHoy);
		}

		// assert
		assertEquals(listaMesasDisponiblesBuscadas.get(0).getPrecioConDescuentoHoy(),
				listaMesasDisponiblesConPrecioHoy.get(0).getPrecioConDescuentoHoy());
		assertEquals(listaMesasDisponiblesBuscadas.get(1).getPrecioConDescuentoHoy(),
				listaMesasDisponiblesConPrecioHoy.get(1).getPrecioConDescuentoHoy());

	}

	@Test
	void NoHayMesasDisponiblesTest() {
		// arrange
		Long precioDescuentoHoy = 190000l;
		List<MesaDto> listaMesasDisponibles = null; // No hay mesas disponibles
		MesaDao mesaDao = Mockito.mock(MesaDao.class);
		ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy = Mockito.mock(ServicioCalcularValorMesaHoy.class);
		Mockito.when(mesaDao.listarMesasDisponibles()).thenReturn(listaMesasDisponibles);

		// act
		ServicioListarMesasDidponibles servicioListarMesasDidponibles = new ServicioListarMesasDidponibles(mesaDao,
				servicioCalcularValorMesaHoy);

		try {

			List<MesaDto> listaMesasDisponiblesBuscadas = servicioListarMesasDidponibles.ejecutar();
			for (MesaDto mesadto : listaMesasDisponiblesBuscadas) {
				mesadto.setPrecioConDescuentoHoy(precioDescuentoHoy);
			}

		} catch (Exception e) {
			// assert
			assertEquals("Lo sentimos, todas las mesas estan reservadas para el evento de este sabado", e.getMessage());
		}

	}

}
