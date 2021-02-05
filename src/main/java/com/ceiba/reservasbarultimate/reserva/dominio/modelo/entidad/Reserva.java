package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad;

import java.util.Date;


import lombok.Data;

@Data
public class Reserva {
		
	private static final String ID_MESA_MESA_VALIDO = "error, El numero de mesa debe ser un valor entre 1 y 9";
	private static final String CANTIDAD_PERSONAS_NO_VALIDAS = "error, Debe especificar la cantidad de personas por mesa: maximo 5 personas";
	private static final String DOCUMENTO_USUARIO_INCORRECTO = "error, Debe ingresar un numero de documento valido, con longitud entre 6 y 12 digitos ";
	private static final String FECHA_RESERVA_INCORRECTA = "error, Solo puede hacer las reservas de miercoles a sabado ";
	private static final Long LONGITUD_MINIMA_DOCUMENTO = 6l;
	private static final Long LONGITUD_MAXIMA_DOCUMENTO = 12l;

	
	private Integer idMesa;
	private Long idUsuario;
	private Date fechaReserva;
	private Integer cantidadPersonas;
	private Long precioReserva;

	public Reserva( Integer idMesa, Long idUsuario, Integer cantidadPersonas) {

		ValidadorCamposReserva.validarNumeroMesa(idMesa, ID_MESA_MESA_VALIDO);
		ValidadorCamposReserva.validarCantidadPersonas(cantidadPersonas, CANTIDAD_PERSONAS_NO_VALIDAS);
		ValidadorCamposReserva.validarDocumentoUsuarioValido(idUsuario,LONGITUD_MINIMA_DOCUMENTO,LONGITUD_MAXIMA_DOCUMENTO, DOCUMENTO_USUARIO_INCORRECTO );
		ValidadorCamposReserva.validarDiaReservaValido(FECHA_RESERVA_INCORRECTA);
		
		this.idMesa = idMesa;
		this.idUsuario = idUsuario;
		this.fechaReserva = new Date();
		this.cantidadPersonas = cantidadPersonas;
	}

}
