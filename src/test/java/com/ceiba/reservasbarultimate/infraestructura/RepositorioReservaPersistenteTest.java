package com.ceiba.reservasbarultimate.infraestructura;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.reservasbarultimate.aplicacion.ComandoReservaTestBuild;
import com.ceiba.reservasbarultimate.dominio.ReservaDtoTestDataBuild;
import com.ceiba.reservasbarultimate.dominio.ReservaTestDataBuild;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.infraestructura.adaptador.repositorio.RepositorioReservaPersistente;

@SpringBootTest
public class RepositorioReservaPersistenteTest {
	
	@Autowired
	RepositorioReservaPersistente repositorioReservaPersistente;
	
	public RepositorioReservaPersistenteTest(){
			
	}
	
	@Test
	void ejecutarCrearReservaTest() {
		
		// arrange
		LocalDate localDate = LocalDate.of(2021, 01, 29);
		Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	
		Reserva reserva = new ReservaTestDataBuild().conFechaReserva(fecha).build();
		ReservaDto reservaDto = new ReservaDtoTestDataBuild().conFechaReserva(fecha).build();

		// act
		ReservaDto resultadoReservaDto = repositorioReservaPersistente.crear(reserva);

		// assert
		assertEquals(reservaDto.getFechaReserva(), resultadoReservaDto.getFechaReserva());
		
	}

}
