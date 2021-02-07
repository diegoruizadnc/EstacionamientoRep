package com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
	private int idMesa;
	private String fila;
	private Long precioBase;
	private Boolean estaDisponible;
	
}
