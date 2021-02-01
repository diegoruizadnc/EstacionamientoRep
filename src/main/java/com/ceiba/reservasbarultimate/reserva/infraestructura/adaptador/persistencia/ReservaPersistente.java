package com.ceiba.reservasbarultimate.reserva.infraestructura.adaptador.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "RESERVAS")
@Data
public class ReservaPersistente  {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;
	@Column(nullable = false)
	private int idMesa;
	@Column(nullable = false)
	private Long idUsuario;
	private Date fechaReserva;
	private int cantidadPersonas;
	private Long precioReserva;

}
