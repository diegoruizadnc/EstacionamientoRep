package com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MesaDto {
	
	private int idMesa;
	private String fila;
	private Long precioBase;
	private Boolean estaDisponible;

}
