package com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ReservaDto {
    
    private Long idReserva;
	private int idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private int cantidadPersonas;
	private Long precioReserva;
	
	public Long getIdReserva() {
		return idReserva;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Date getFechaReserva() {
		return (Date) fechaReserva.clone();
	}
	
	public int getCantidadPersonas() {
		return cantidadPersonas;
	}
	
	public Long getPrecioReserva() {
		return precioReserva;
	}

	

}
