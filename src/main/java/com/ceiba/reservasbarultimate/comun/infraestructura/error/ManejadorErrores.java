package com.ceiba.reservasbarultimate.comun.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.reservasbarultimate.comun.dominio.excepciones.CampoRequeridoExcepcion;
import com.ceiba.reservasbarultimate.comun.dominio.excepciones.ConflictoEstadoRecursoExcepcion;
import com.ceiba.reservasbarultimate.comun.dominio.excepciones.DatosNoEncontradosExcepcion;
import com.ceiba.reservasbarultimate.comun.dominio.excepciones.ValorNoValidoExcepcion;

@ControllerAdvice
public class ManejadorErrores {

	private static final String ERROR_INESPERADO_CONTACTAR_ADMIN = "Error inesperado en reservas Bar, contacte al administrador";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ManejadorErrores() {

		CODIGOS_ESTADO.put(CampoRequeridoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ValorNoValidoExcepcion.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(DatosNoEncontradosExcepcion.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
		CODIGOS_ESTADO.put(ConflictoEstadoRecursoExcepcion.class.getSimpleName(), HttpStatus.CONFLICT.value());
		
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
