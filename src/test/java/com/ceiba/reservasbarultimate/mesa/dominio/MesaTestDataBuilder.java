package com.ceiba.reservasbarultimate.mesa.dominio;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

public class MesaTestDataBuilder {

	private Integer idMesa;
	private String fila;
	private Long precioBase;
	private Boolean estaDisponible;

	public MesaTestDataBuilder() {

		idMesa = 1;
		fila = "1";
		precioBase = 200000l;
		estaDisponible = true;

	}
	
	public MesaTestDataBuilder conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}
	
	
	public MesaTestDataBuilder conEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
		return this;
	}
	
	
	 public Mesa build() {
	        return new Mesa(idMesa,fila,precioBase,estaDisponible);
	    }

}
