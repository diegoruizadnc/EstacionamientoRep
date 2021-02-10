package com.ceiba.reservasbarultimate.mesa.builders;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;

public class MesaDtoTestDataBuilder {
	
	
	private int idMesa;
	private String fila;
	private Long precioBase;
	private Long precioConDescuentoHoy;
	private Boolean estaDisponible;
	
	private List<MesaDto> listaMesasDto = new ArrayList<>();

	public MesaDtoTestDataBuilder() {

		idMesa = 1;
		fila = "1";
		precioBase = 200000l;
		estaDisponible = true;
		precioConDescuentoHoy = 190000l;

	}
	
	public MesaDtoTestDataBuilder conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}
	
	public MesaDtoTestDataBuilder conFila(String fila) {
		this.fila = fila;
		return this;
	}
	
	public MesaDtoTestDataBuilder conPrecioBase(Long precioBase) {
		this.precioBase = precioBase;
		return this;
	}
	
	
	public MesaDtoTestDataBuilder conEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
		return this;
	}
	
	public MesaDtoTestDataBuilder conPrecioConDescuentoHoy(Long precioConDescuentoHoy) {
		this.precioConDescuentoHoy = precioConDescuentoHoy;
		return this;
	}
	
	
	 public MesaDto build() {
	        return new MesaDto(idMesa,fila,precioBase, estaDisponible);
	    }
	 
	   public List<MesaDto> buildListaMesasDto() {
		   MesaDto mesa1 =  new MesaDto(1, "1", 200000l, true);
		   MesaDto mesa2 =  new MesaDto(2, "1", 200000l, true);;
		 /*  MesaDto mesa3 =  new MesaDto(3, "2", 150000l, true);
		   MesaDto mesa4 =  new MesaDto(3, "2", 150000l, true);
		   MesaDto mesa5 =  new MesaDto(3, "2", 150000l, true);*/
	        
		   listaMesasDto.add(mesa1);
		   listaMesasDto.add(mesa2);
		  /* listaMesasDto.add(mesa3);
		   listaMesasDto.add(mesa4);
		   listaMesasDto.add(mesa5);*/
	        
	        return listaMesasDto;
	    }
	   
	   public List<MesaDto> buildListaMesasDtoConPrecioHoy() {
		   MesaDto mesa1 =  new MesaDto(1, "1", 200000l, true);
		   		   mesa1.setPrecioConDescuentoHoy(190000l);
		   MesaDto mesa2 =  new MesaDto(2, "1", 200000l, true);
		   		   mesa2.setPrecioConDescuentoHoy(190000l);
		 /*  MesaDto mesa3 =  new MesaDto(3, "2", 150000l, true);
		   		   mesa3.setPrecioConDescuentoHoy(142500l);
		   MesaDto mesa4 =  new MesaDto(3, "2", 150000l, true);
		           mesa4.setPrecioConDescuentoHoy(142500l);
		   MesaDto mesa5 =  new MesaDto(3, "2", 150000l, true);
		           mesa5.setPrecioConDescuentoHoy(142500l);*/
	        
		   listaMesasDto.add(mesa1);
		   listaMesasDto.add(mesa2);
		  /* listaMesasDto.add(mesa3);
		   listaMesasDto.add(mesa4);
		   listaMesasDto.add(mesa5);*/
	        
	        return listaMesasDto;
	    }

}
