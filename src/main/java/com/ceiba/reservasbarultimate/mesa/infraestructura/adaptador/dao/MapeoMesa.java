package com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.dao;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia.MesaPersistente;

public class MapeoMesa {
	
private  MapeoMesa() {
		
	}
	
	public static MesaDto convertirToMesaDto(MesaPersistente mesaPersistente){
		return new MesaDto( 
				mesaPersistente.getIdMesa(),mesaPersistente.getFila(),mesaPersistente.getPrecioBase(),mesaPersistente.getEstaDisponible()
				);
	}

}
