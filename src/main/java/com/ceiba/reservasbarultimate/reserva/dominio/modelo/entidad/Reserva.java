package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad;

import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.ValidadorCampos;

import lombok.Getter;

@Getter
public class Reserva {
	
	/*private static final String ID_MESA_OBLIGATORIO = "error, El numero de mesa es obligatorio";
	private static final String ID_USUARIO_OBLIGATORIO = "error, El Id del usuario  es obligatorio";
	private static final String CANTIDAD_PERSONAS_OBLIGATORIO = "error, Debe ingresar el numero de personas que haran parte de la mesa, para tenerla con los protocolos covid";
	private static final String PRECIO_RESERVA_OBLIGATORIO= "error, Debe ingresar valor de la reservacion";*/
	
	private static final String ID_MESA_MESA_VALIDO = "error, El numero de mesa debe ser un valor entre 1 y 9";
	private static final String CANTIDAD_PERSONAS_NO_VALIDAS = "error, La cantidad de personas por reserva debe estar entre 1 y 5";
	private static final String DIA_RESERVA_VALIDO = "error, Solo puede hacer las reservas de miercoles a sabado";
	private static final String PRECIO_RESERVA_INCORRECTO = "error, El valor que intenta pagar es incorrecto, usted debe cancelar: ";
	
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;

	public Reserva( Integer idMesa, Long idUsuario, Date fechaReserva, Integer cantidadPersonas,
			Long precioReserva) {
		/*ValidadorCampos.validarNumeroMesa(idMesa, ID_MESA_OBLIGATORIO);  
		ValidadorCampos.validarNonNull(idUsuario, ID_USUARIO_OBLIGATORIO);
		ValidadorCampos.validarNonNull(cantidadPersonas, CANTIDAD_PERSONAS_OBLIGATORIO);
		ValidadorCampos.validarNonNull(precioReserva, PRECIO_RESERVA_OBLIGATORIO);*/
		
		
		ValidadorCampos.validarNumeroMesa(idMesa, ID_MESA_MESA_VALIDO);
		ValidadorCampos.validarDiaReservaValido(fechaReserva, DIA_RESERVA_VALIDO);
		ValidadorCampos.validarCantidadPersonas(cantidadPersonas, CANTIDAD_PERSONAS_NO_VALIDAS);
		ValidadorCampos.validarPrecioCorrecto(precioReserva,idMesa, fechaReserva, PRECIO_RESERVA_INCORRECTO);
		
		this.idMesa = idMesa;
		this.idUsuario = idUsuario;
		this.fechaReserva = fechaReserva;
		this.cantidadPersonas = cantidadPersonas;
		this.precioReserva = precioReserva;
	}

}
