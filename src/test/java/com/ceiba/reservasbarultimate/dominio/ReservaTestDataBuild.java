package com.ceiba.reservasbarultimate.dominio;


import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;


public class ReservaTestDataBuild {

	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;
	
	

	public ReservaTestDataBuild() {
		
		 
		idMesa = 1;
		idUsuario = 345678l;
		fechaReserva = new Date();
		cantidadPersonas = 4;
		precioReserva = 200000l;

	}
	

	public ReservaTestDataBuild conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}

	public ReservaTestDataBuild conIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ReservaTestDataBuild conFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public ReservaTestDataBuild conCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
		return this;
	}
	
	public ReservaTestDataBuild conPrecioReserva(Long precioReserva) {
		this.precioReserva = precioReserva;
		return this;
	}
	
	 public Reserva build() {
	        return new Reserva(idMesa,idUsuario, fechaReserva,cantidadPersonas,precioReserva);
	    }
}
