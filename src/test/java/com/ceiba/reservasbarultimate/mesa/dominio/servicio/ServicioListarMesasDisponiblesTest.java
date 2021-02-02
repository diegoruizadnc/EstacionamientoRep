package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.dao.MesaDaoPersistente;


@SpringBootTest
 class ServicioListarMesasDisponiblesTest {
	
	@Autowired
	MesaDao  servicioListarMesasDidponibles;
	
	@Test
	 void listarMesasDisponiblesTest(){
		//arrange
		//List<MesaDto> listaMesasDisponibles=new MesaTestDataBuilder().getListaMesas();
		List<MesaDto> lisaMesas = new ArrayList<>();
		MesaDto mesa1=new MesaDto(1, "1", 200000l, true);
		MesaDto mesa2=new MesaDto(2, "1", 200000l, true);
		
		MesaDto mesa3=new MesaDto(3, "2", 150000l, true);
		MesaDto mesa4=new MesaDto(4, "2", 150000l, true);
		MesaDto mesa5=new MesaDto(5, "2", 150000l, true);
		
		MesaDto mesa6=new MesaDto(6, "3", 100000l, true);
		MesaDto mesa7=new MesaDto(7, "3", 100000l, true);
		MesaDto mesa8=new MesaDto(8, "3", 100000l, true);
		MesaDto mesa9=new MesaDto(9, "3", 100000l, true);
		lisaMesas.add(mesa1);
		lisaMesas.add(mesa2);
		lisaMesas.add(mesa3);
		lisaMesas.add(mesa4);
		lisaMesas.add(mesa5);
		lisaMesas.add(mesa6);
		lisaMesas.add(mesa7);
		lisaMesas.add(mesa8);
		lisaMesas.add(mesa9);
		//act
		List<MesaDto> listaMesasDisponiblesResultado = servicioListarMesasDidponibles.listarMesasDisponibles();
		//assert
		assertEquals(lisaMesas.size(),listaMesasDisponiblesResultado.size());
	}


}
