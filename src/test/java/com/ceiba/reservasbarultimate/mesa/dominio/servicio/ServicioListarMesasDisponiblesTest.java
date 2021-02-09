package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.reservasbarultimate.dominio.ReservaTestDataBuild;
import com.ceiba.reservasbarultimate.mesa.dominio.MesaTestDataBuilder;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.repositorio.MesaRepositorio;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.dao.MesaDaoPersistente;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;


@SpringBootTest
 class ServicioListarMesasDisponiblesTest {
	
	@Autowired
	ServicioListarMesasDidponibles  servicioListarMesasDidponibles;
	
	@Autowired
	MesaRepositorio  mesaRepositorio;
	
	@Test
	 void listarMesasDisponiblesTodasTest(){
		//arrange
		//List<MesaDto> listaMesasDisponibles=new MesaTestDataBuilder().getListaMesas();
		//act
		List<MesaDto> listaMesasDisponiblesResultado = servicioListarMesasDidponibles.ejecutar();
		//assert
		assertEquals(9,listaMesasDisponiblesResultado.size());
	} 
	
	/*@Test
	 void listarMesasDisponiblesParcialTest() throws Exception{
		//arrange
		 Mesa mesa= new MesaTestDataBuilder().conIdMesa(1).conEstaDisponible(false).build();
		//act
		mesaRepositorio.actualizar(mesa);
		List<MesaDto> listaMesasDisponiblesResultado = servicioListarMesasDidponibles.ejecutar();
		//assert
		assertEquals(8,listaMesasDisponiblesResultado.size());
	} */


}
