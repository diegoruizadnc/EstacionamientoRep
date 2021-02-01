package com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservaDto {
    
    private Long idReserva;
	private int idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private int cantidadPersonas;
	private Long precioReserva;

}
