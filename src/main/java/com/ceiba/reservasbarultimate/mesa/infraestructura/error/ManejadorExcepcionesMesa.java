package com.ceiba.reservasbarultimate.mesa.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.reservasbarultimate.mesa.dominio.excepciones.MesaMensajeExcepcion;
import com.ceiba.reservasbarultimate.reserva.infraestructura.error.Error;



@ControllerAdvice
public class ManejadorExcepcionesMesa {

	private static final String ERROR_INESPERADO_CONTACTAR_ADMIN = "Error inesperado en reservas Bar, contacte al administrador";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ManejadorExcepcionesMesa() {

		CODIGOS_ESTADO.put(MesaMensajeExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllException(Exception exception) {
		ResponseEntity<Error> resultado;

		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

		if (codigo != null) {
			Error error = new Error(excepcionNombre, mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
			Error error = new Error(excepcionNombre, ERROR_INESPERADO_CONTACTAR_ADMIN);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resultado;

	}
}
