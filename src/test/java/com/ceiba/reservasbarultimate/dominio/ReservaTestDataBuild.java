package com.ceiba.reservasbarultimate.dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;

import lombok.Data;

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
		//ponerFechaValida();

	}
	
	
	
	/*public void ponerFechaValida(){
		 String sDate1="28/01/2021";  
		 Date fecha = null;
		try {
			fecha = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fechaReserva = fecha;
	}*/

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
