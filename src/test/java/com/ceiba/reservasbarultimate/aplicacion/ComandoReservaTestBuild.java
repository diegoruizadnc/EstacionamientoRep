package com.ceiba.reservasbarultimate.aplicacion;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.ceiba.reservasbarultimate.dominio.ReservaTestDataBuild;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;

public class ComandoReservaTestBuild {
	
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;
	
	public ComandoReservaTestBuild() {
		
		 
		idMesa = 1;
		idUsuario = 345678l;
		fechaReserva = new Date();
		cantidadPersonas = 4;
		precioReserva = 200000l;
		ponerFechaValida();

	}
	
	public void ponerFechaValida(){
	    LocalDate localDate  = LocalDate.of(2021, 01, 28);
	    Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.fechaReserva = date;
	}
	
	public ComandoReservaTestBuild conFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	 public ComandoReserva build() {
	        return new ComandoReserva(idMesa,idUsuario, fechaReserva,cantidadPersonas,precioReserva);
	    }

}
