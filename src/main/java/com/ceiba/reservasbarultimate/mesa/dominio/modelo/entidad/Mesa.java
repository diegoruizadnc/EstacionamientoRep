package com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Mesa {
	private int idMesa;
	private String fila;
	private Long precioBase;
	private Boolean estaDisponible;
	
	public Mesa() {
	
	}
	

}
