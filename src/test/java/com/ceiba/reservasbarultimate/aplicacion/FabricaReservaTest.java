package com.ceiba.reservasbarultimate.aplicacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ceiba.reservasbarultimate.dominio.ReservaTestDataBuild;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.fabrica.FabricaReserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

@SpringBootTest
class FabricaReservaTest {
	
	 @Autowired
	 FabricaReserva  mockedfabricaReserva ;
	
	 
	 public FabricaReservaTest(){
		 
	 }
	 
	 @Test
	 void crearUnaReservaAPartirDeUnComandoReserva() {
		 
			//arrange
		 LocalDate localDate  = LocalDate.of(2021, 01, 29);
		 Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		 ComandoReserva comandoReserva= new ComandoReservaTestBuild().conFechaReserva(fecha).build();
		 Reserva reserva= new ReservaTestDataBuild().conFechaReserva(fecha).build();
		 
		 //FabricaReserva  mockedfabricaReserva = mock(FabricaReserva.class);
		
		 
		 Reserva resultadoReserva = mockedfabricaReserva.crearReserva(comandoReserva);
		
		//act
		
		 //assert
		 assertEquals(reserva.getFechaReserva(),resultadoReserva.getFechaReserva());
		 
	 }

}