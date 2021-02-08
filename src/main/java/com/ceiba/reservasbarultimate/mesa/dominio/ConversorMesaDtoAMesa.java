package com.ceiba.reservasbarultimate.mesa.dominio;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;

@Component
public final class ConversorMesaDtoAMesa {
	
	private  ConversorMesaDtoAMesa() {

	}
	
	public static Mesa ejecutar(MesaDto mesaDto){
		
		Mesa mesa = new Mesa();

		mesa.setIdMesa(mesaDto.getIdMesa());
		mesa.setFila(mesaDto.getFila());
		mesa.setPrecioBase(mesaDto.getPrecioBase());
		mesa.setEstaDisponible(mesaDto.getEstaDisponible());
		
		return mesa;
	}

}
