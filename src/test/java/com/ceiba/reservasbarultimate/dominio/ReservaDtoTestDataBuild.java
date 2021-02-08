package com.ceiba.reservasbarultimate.dominio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;

public class ReservaDtoTestDataBuild {
	
	private Long idReserva;
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;
	
	

	public ReservaDtoTestDataBuild() {
		
		idReserva = 1l;
		idMesa = 1;
		idUsuario = 34567899l;
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

	public ReservaDtoTestDataBuild conIdMesa(Integer idMesa) {
		this.idMesa = idMesa;
		return this;
	}

	public ReservaDtoTestDataBuild conIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	
	public ReservaDtoTestDataBuild conFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
		return this;
	}
	
	public ReservaDtoTestDataBuild conCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
		return this;
	}
	
	public ReservaDtoTestDataBuild conPrecioReserva(Long precioReserva) {
		this.precioReserva = precioReserva;
		return this;
	}
	
	 public ReservaDto build() {
	        return new ReservaDto(idReserva,idMesa,idUsuario, fechaReserva,cantidadPersonas,precioReserva);
	    }

}
