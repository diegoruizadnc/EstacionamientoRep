package com.ceiba.reservasbarultimate.reserva;

import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {
	
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;
	
	
	public ReservaTestDataBuilder() {
		//Calendar myCalendar = new GregorianCalendar(2021, 1, 28);
		//Date myDate = myCalendar.getTime();
		this.idMesa = null;
		this.idUsuario = 10302l;
		this.fechaReserva = new Date();
		this.cantidadPersonas = 4;
		this.precioReserva = 200000l;

	}
	
	  public Reserva withoutIdMesa() {
		  return new Reserva(idMesa, idUsuario, fechaReserva, cantidadPersonas, precioReserva);
	    }

	    public Reserva build() {
	        return new Reserva(idMesa, idUsuario, fechaReserva, cantidadPersonas, precioReserva);
	    }

}
