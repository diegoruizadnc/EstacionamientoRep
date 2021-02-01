package com.ceiba.reservasbarultimate.reserva.dominio;

import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;

public class ReservaDtoTestDataBuilder {
	
	private Long idReserva;
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;
	

	public ReservaDtoTestDataBuilder() {
		//Calendar myCalendar = new GregorianCalendar(2021, 1, 28);
		//Date myDate = myCalendar.getTime();
		this.idReserva = 1l;
		this.idMesa = null;
		this.idUsuario = 10302l;
		this.fechaReserva = new Date();
		this.cantidadPersonas = 4;
		this.precioReserva = 200000l;

	}
	
	  public ReservaDto withoutIdMesa() {
		  return new ReservaDto(idReserva,idMesa, idUsuario, fechaReserva, cantidadPersonas, precioReserva);
	    }

	    public ReservaDto build() {
	        return new ReservaDto(idReserva,idMesa, idUsuario, fechaReserva, cantidadPersonas, precioReserva);
	    }

}
