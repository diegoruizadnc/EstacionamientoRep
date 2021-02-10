package com.ceiba.reservasbarultimate.reserva.builders;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {
	
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;
	
	

	public ReservaTestDataBuilder() {
		
		 
		idMesa = 1;
		idUsuario = 34567899l;
		fechaReserva = new Date();
		cantidadPersonas = 4;
		precioReserva = 200000l;
		ponerFechaValida();

	}
	
	
	
	public void ponerFechaValida(){
	    LocalDate localDate  = LocalDate.of(2021, 02, 12);
	    Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.fechaReserva = date;
	}

	public ReservaTestDataBuilder conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}

	public ReservaTestDataBuilder conIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ReservaTestDataBuilder conFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public ReservaTestDataBuilder conCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
		return this;
	}
	
	public ReservaTestDataBuilder conPrecioReserva(Long precioReserva) {
		this.precioReserva = precioReserva;
		return this;
	}
	
	 public Reserva build() {
	        return new Reserva(idMesa,idUsuario,cantidadPersonas);
	    }

}
