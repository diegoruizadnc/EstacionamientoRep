package com.ceiba.reservasbarultimate.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.servicio.ServicioCrearReserva;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class ReservaTest {
	
   
	
	@Test
	 void crearReservaDatosValidos() {
		//arrange
		  LocalDate localDate  = LocalDate.of(2021, 02, 13);
		  Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		  Reserva reserva= new ReservaTestDataBuild().conFechaReserva(date).build();
		  ReservaDto reservaDto= new ReservaDtoTestDataBuild().conFechaReserva(date).build();
		  
		  ServicioCrearReserva  mockedservicioCrearReserva = Mockito.mock(ServicioCrearReserva.class); 
		  Mockito.when(mockedservicioCrearReserva.ejecutar(reserva)).thenReturn(reservaDto);
	}
	
	
	@Test
	 void crearReservaNumeroMesaNulo() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		Reserva reserva= new ReservaTestDataBuild().conIdMesa(null).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaNumeroMesaMayorNueve() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		Reserva reserva= new ReservaTestDataBuild().conIdMesa(10).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaNumeroMesaNegativo() throws Exception{
		
		//arrange
		Date fecha = new Date();
		//act
		try {
		@SuppressWarnings("unused")
		 Reserva reserva= new ReservaTestDataBuild().conIdMesa(-1).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El numero de mesa debe ser un valor entre 1 y 9", e.getMessage() );
		}
		
		
	}
	
	
	@Test
	 void crearReservaDiaNoValido() throws Exception{
		
		//arrange
		LocalDate localDate  = LocalDate.of(2021, 01, 25);
	    Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//act
		try { 
			Reserva reserva= new ReservaTestDataBuild().conFechaReserva(fecha).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado",e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaFechaNulo() throws Exception{
		//arrange
		Date fecha = null;
		//act
		try {
			Reserva reserva= new ReservaTestDataBuild().conFechaReserva(fecha).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, Solo puede hacer las reservas de miercoles a sabado",e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaCantidadPersonasNoValida() throws Exception{
		//arrange
		Integer cantidadPersonas = 10;
		//act
		try {
			Reserva reserva= new ReservaTestDataBuild().conCantidadPersonas(cantidadPersonas).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, Debe especificar la cantidad de personas por mesa: maximo 5 personas",e.getMessage() );
		}
		
		
	}
	
	@Test
	 void crearReservaCantidadPersonasNulo() throws Exception{
		//arrange
		Integer cantidadPersonas = null;
		//act
		try {
			Reserva reserva= new ReservaTestDataBuild().conCantidadPersonas(cantidadPersonas).build();
		//assert
		}catch (Exception e) {
			assertEquals("error, Debe especificar la cantidad de personas por mesa: maximo 5 personas",e.getMessage() );
		}
		
		
	}
	
	
	@Test
	 void crearReservaPagandoCompletoEnDiaDeDescuento() throws Exception{
		//arrange
		Long precioReserva = 200000l;
		//act
		try {
			Reserva reserva= new ReservaTestDataBuild().build();
		//assert
		}catch (Exception e) {
			assertEquals("error, El valor que intenta pagar es incorrecto, usted debe cancelar: 190000",e.getMessage() );
		}
		
		
	}

}
