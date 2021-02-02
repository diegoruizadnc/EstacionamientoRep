package com.ceiba.reservasbarultimate.mesa.dominio;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;

import lombok.Getter;

@Getter
public class MesaTestDataBuilder {
	
	private List<MesaDto> listaMesas = null;
	
	public MesaTestDataBuilder() {
		this.listaMesas = listaMesasDisponbles();
	}
	
	public  List<MesaDto> listaMesasDisponbles(){
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
		
		return lisaMesas;
	}

}
