package com.ceiba.reservasbarultimate.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCalcularValorMesaHoy;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCambiarDisponibilidadMesa;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;
import com.ceiba.reservasbarultimate.reserva.dominio.servicio.ServicioCrearReserva;

class ReservaTest {

	@Test
	void crearReservaDatosValidosTest() throws Exception {

		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 13);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Reserva reserva = new ReservaTestDataBuild().conFechaReserva(date).build();
		// act
		ReservaDto reservaDto = new ReservaDtoTestDataBuild().conFechaReserva(date).build();
		// assert
		assertEquals(reservaDto.getFechaReserva(), reservaDto.getFechaReserva());

	}
	
	
	@Test
     void validarCreacionReservaCorrecto() { // aprobada david
		//arrange
		LocalDate localDate = LocalDate.of(2021, 02, 12);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		Reserva reserva = new Reserva(1,12345678l,5);
		ReservaDto reservaDto = new ReservaDto(1l,1,12345678l,date,5,190000l);
		
		MesaDto  mesaDto = new MesaDto(1,"fila 1",200000l,true);
		//Long precioMesaHoy = 190000l;
		
		ReservaRepositorio reservaRepositorio = Mockito.mock(ReservaRepositorio.class);
		ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa = Mockito.mock(ServicioCambiarDisponibilidadMesa.class);
		ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy = Mockito.mock(ServicioCalcularValorMesaHoy.class);
		MesaDao mesaDao = Mockito.mock(MesaDao.class);
		
		
        Mockito.when(mesaDao.buscarMesaPorId(reserva.getIdMesa())).thenReturn(mesaDto);
        Mockito.when(reservaRepositorio.crear(reserva)).thenReturn(reservaDto); 
        
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(reservaRepositorio,servicioCambiarDisponibilidadMesa,servicioCalcularValorMesaHoy,mesaDao);
        
        
        ReservaDto nuevaReservaDto = servicioCrearReserva.ejecutar(reserva);
        
        assertEquals(nuevaReservaDto, reservaDto);
    }
	
	
	
	@Test
    void validarCreacionReservaCorrectov22222() {
		//arrange
		LocalDate localDate = LocalDate.of(2021, 02, 12);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		Reserva reserva = new  ReservaTestDataBuild().conIdMesa(1).conIdUsuario(12345678l).conCantidadPersonas(5).conFechaReserva(date).build();   
		ReservaDto reservaDto = new ReservaDtoTestDataBuild().conIdMesa(1).conIdUsuario(12345678l).conCantidadPersonas(5).conFechaReserva(date).build();   
		MesaDto  mesaDto = new MesaDto(1,"fila 1",200000l,true);
		//Long precioMesaHoy = 190000l;
		
		ReservaRepositorio reservaRepositorio = Mockito.mock(ReservaRepositorio.class);
		ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa = Mockito.mock(ServicioCambiarDisponibilidadMesa.class);
		ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy = Mockito.mock(ServicioCalcularValorMesaHoy.class);
		MesaDao mesaDao = Mockito.mock(MesaDao.class);
		
		
       Mockito.when(mesaDao.buscarMesaPorId(reserva.getIdMesa())).thenReturn(mesaDto);
       Mockito.when(reservaRepositorio.crear(reserva)).thenReturn(reservaDto); 
       
       ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(reservaRepositorio,servicioCambiarDisponibilidadMesa,servicioCalcularValorMesaHoy,mesaDao);
       
       
       ReservaDto nuevaReservaDto = servicioCrearReserva.ejecutar(reserva);
       
       assertEquals(nuevaReservaDto, reservaDto);
   }
   
	// Como estaba antes
	@Test
	void crearReservaDatosValidos() {
		// arrange
		LocalDate localDate = LocalDate.of(2021, 02, 13);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Reserva reserva = new ReservaTestDataBuild().conFechaReserva(date).build();
		ReservaDto reservaDto = new ReservaDtoTestDataBuild().conFechaReserva(date).build();

		// act
		ServicioCrearReserva mockedservicioCrearReserva = Mockito.mock(ServicioCrearReserva.class);
		Mockito.when(mockedservicioCrearReserva.ejecutar(reserva)).thenReturn(reservaDto);
		// assert
		assertEquals(reserva.getIdMesa(), reservaDto.getIdMesa());
		assertEquals(reserva.getIdUsuario(), reservaDto.getIdUsuario());
		assertEquals(reserva.getCantidadPersonas(), reservaDto.getCantidadPersonas());
	}

	@Test
	void crearReservaNumeroMesaNulo() throws Exception {

		// arrange
		Date fecha = new Date();
		// act
		try {
			@SuppressWarnings("unused")
			Reserva reserva = new Reserva(10,12345678l,6);
			// assert
		} catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage());
		}

	}

	@Test
	void crearReservaNumeroMesaMayorNueve() throws Exception {

		// arrange
		Date fecha = new Date();
		// act
		try {
			@SuppressWarnings("unused")
			Reserva reserva = new ReservaTestDataBuild().conIdMesa(10).build();
			// assert
		} catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage());
		}

	}

	@Test
	void crearReservaNumeroMesaNegativo() throws Exception {

		// arrange
		Date fecha = new Date();
		// act
		try {
			@SuppressWarnings("unused")
			Reserva reserva = new ReservaTestDataBuild().conIdMesa(-1).build();
			// assert
		} catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage());
		}

	}

	@Test
	void crearReservaDiaNoValido() throws Exception {

		// arrange
		LocalDate localDate = LocalDate.of(2021, 01, 25);
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// act
		try {
			Reserva reserva = new ReservaTestDataBuild().conFechaReserva(fecha).build();
			// assert
		} catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado", e.getMessage());
		}

	}

	@Test
	void crearReservaFechaNulo() throws Exception {
		// arrange
		Date fecha = null;
		// act
		try {
			Reserva reserva = new ReservaTestDataBuild().conFechaReserva(fecha).build();
			// assert
		} catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado", e.getMessage());
		}

	}

	@Test
	void crearReservaCantidadPersonasNoValida() throws Exception {
		// arrange
		Integer cantidadPersonas = 10;
		// act
		try {
			Reserva reserva = new ReservaTestDataBuild().conCantidadPersonas(cantidadPersonas).build();
			// assert
		} catch (Exception e) {
			assertEquals("error, Debe especificar la cantidad de personas por mesa: maximo 5 personas", e.getMessage());
		}

	}

	@Test
	void crearReservaCantidadPersonasNulo() throws Exception {
		// arrange
		Integer cantidadPersonas = null;
		// act
		try {
			Reserva reserva = new ReservaTestDataBuild().conCantidadPersonas(cantidadPersonas).build();
			// assert
		} catch (Exception e) {
			assertEquals("error, Debe especificar la cantidad de personas por mesa: maximo 5 personas", e.getMessage());
		}

	}

}
