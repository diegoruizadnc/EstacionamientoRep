package com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.repositorio;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia.MesaPersistente;

public class ConversorMesaAMesaPersistente {
	
	private ConversorMesaAMesaPersistente() {

	}
	
	public static MesaPersistente ejecutar(Mesa mesa){
		
		MesaPersistente mesaPersistente=new MesaPersistente();

		mesaPersistente.setIdMesa(mesa.getIdMesa());
		mesaPersistente.setFila(mesa.getFila());
		mesaPersistente.setPrecioBase(mesa.getPrecioBase());
		mesaPersistente.setEstaDisponible(mesa.getEstaDisponible());

		return mesaPersistente;
	}
	

}


