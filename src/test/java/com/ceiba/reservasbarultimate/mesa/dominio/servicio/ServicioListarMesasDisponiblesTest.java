package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.reservasbarultimate.mesa.dominio.MesaTestDataBuilder;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.dao.MesaDaoPersistente;


@SpringBootTest
 class ServicioListarMesasDisponiblesTest {
	
	@Autowired
	MesaDaoPersistente  servicioListarMesasDidponibles;
	
	@Test
	 void listarMesasDisponiblesTest(){
		//arrange
		List<MesaDto> listaMesasDisponibles=new MesaTestDataBuilder().getListaMesas();
		//act
		List<MesaDto> listaMesasDisponiblesResultado = servicioListarMesasDidponibles.listarMesasDisponibles();
		//assert
		assertEquals(listaMesasDisponibles.size(),listaMesasDisponiblesResultado.size());
	}


}
