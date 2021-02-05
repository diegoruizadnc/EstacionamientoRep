package com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class MesaDto {
	
	private int idMesa;
	private String fila;
	private Long precioBase;
	private Long precioConDescuentoHoy;
	private Boolean estaDisponible;
	
	public MesaDto(int idMesa, String fila, Long precioBase, Boolean estaDisponible) {
		super();
		this.idMesa = idMesa;
		this.fila = fila;
		this.precioBase = precioBase;
		this.estaDisponible = estaDisponible;
	}


}
