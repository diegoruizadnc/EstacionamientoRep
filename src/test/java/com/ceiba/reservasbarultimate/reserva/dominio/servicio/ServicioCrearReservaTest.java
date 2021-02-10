package com.ceiba.reservasbarultimate.reserva.dominio.servicio;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.reservasbarultimate.comun.dominio.excepciones.DatosNoEncontradosExcepcion;
import com.ceiba.reservasbarultimate.mesa.builders.MesaDtoTestDataBuilder;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCalcularValorMesaHoy;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCambiarDisponibilidadMesa;
import com.ceiba.reservasbarultimate.reserva.builders.ReservaDtoTestDataBuilder;
import com.ceiba.reservasbarultimate.reserva.builders.ReservaTestDataBuilder;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;

class ServicioCrearReservaTest {

	@Test
	void crearReservaConFlujoDeDatosOKTest() {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 12);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Reserva reserva = new ReservaTestDataBuilder().conIdMesa(1).conIdUsuario(12345678l).conCantidadPersonas(5)
				.conFechaReserva(date).build();
		ReservaDto reservaDto = new ReservaDtoTestDataBuilder().conIdMesa(1).conIdUsuario(12345678l)
				.conCantidadPersonas(5).conFechaReserva(date).build();
		MesaDto mesaDto = new MesaDtoTestDataBuilder().conIdMesa(1).conFila("1").conPrecioBase(200000l)
				.conEstaDisponible(true).build();

		ReservaRepositorio reservaRepositorio = Mockito.mock(ReservaRepositorio.class);
		ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa = Mockito
				.mock(ServicioCambiarDisponibilidadMesa.class);
		ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy = Mockito.mock(ServicioCalcularValorMesaHoy.class);
		MesaDao mesaDao = Mockito.mock(MesaDao.class);

		Mockito.when(mesaDao.buscarMesaPorId(reserva.getIdMesa())).thenReturn(mesaDto);
		Mockito.when(reservaRepositorio.crear(reserva)).thenReturn(reservaDto);

		// act
		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(reservaRepositorio,
				servicioCambiarDisponibilidadMesa, servicioCalcularValorMesaHoy, mesaDao);

		ReservaDto nuevaReservaDto = servicioCrearReserva.ejecutar(reserva);
		
		//assert
		assertEquals(nuevaReservaDto, reservaDto);
	}
	
	@Test
	void intentarCrearReservaDeMesaNoExisteTest() throws Exception {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 12);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Reserva reserva = new ReservaTestDataBuilder().conIdMesa(1).conIdUsuario(12345678l).conCantidadPersonas(5)
				.conFechaReserva(date).build();
		ReservaDto reservaDto = new ReservaDtoTestDataBuilder().conIdMesa(1).conIdUsuario(12345678l)
				.conCantidadPersonas(5).conFechaReserva(date).build();
		
		MesaDto mesaDto = new MesaDtoTestDataBuilder().conPrecioBase(null).build(); // No Encontró la mesa
 

		ReservaRepositorio reservaRepositorio = Mockito.mock(ReservaRepositorio.class);
		ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa = Mockito
				.mock(ServicioCambiarDisponibilidadMesa.class);
		ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy = Mockito.mock(ServicioCalcularValorMesaHoy.class);
		MesaDao mesaDao = Mockito.mock(MesaDao.class);

		Mockito.when(mesaDao.buscarMesaPorId(reserva.getIdMesa())).thenReturn(mesaDto);
		Mockito.when(reservaRepositorio.crear(reserva)).thenReturn(reservaDto);

		// act
		ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(reservaRepositorio,
				servicioCambiarDisponibilidadMesa, servicioCalcularValorMesaHoy, mesaDao);
        
		/*try {
			ReservaDto nuevaReservaDto = servicioCrearReserva.ejecutar(reserva);
			fail("No se lanzo la excepcion esperada");
		} 
		catch(Exception e) {
			//assert
			assertEquals("La mesa que se esta buscando NO existe", e.getMessage());
		}	*/
		
		// 
		Assertions.assertThrows(DatosNoEncontradosExcepcion.class, ()->{servicioCrearReserva.ejecutar(reserva);});
		
	}

}
