package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones;

import java.util.Date;

import com.ceiba.reservasbarultimate.util.Utiles;


public final class ValidadorCampos {
	
	
	private ValidadorCampos(){		
	}
	
	public static void validarNonNull(Object objeto, String errorMessage){
		if(objeto == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
	}
	
	public static void validarNumeroMesa(Integer idMesa, String errorMessage){
		if(idMesa == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		if(idMesa < 0 || idMesa > 9 ){
			throw new CamposReservaExcepcion(errorMessage);
		}
				
	}
	
	public static void validarCantidadPersonas(Integer cantidadPersonas, String errorMessage){
		if(cantidadPersonas == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		if(cantidadPersonas <= 0 || cantidadPersonas > 5 ){
			throw new CamposReservaExcepcion(errorMessage);
		}
	}
	
	public static void validarPrecioCorrecto(Long precioReserva, int idMesa, Date fechaReserva, String errorMessage){
		if(precioReserva == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
        Long valorNetoReserva ;
        valorNetoReserva = Utiles.calcularValorReserva(fechaReserva,idMesa);
		if(!precioReserva.equals(valorNetoReserva))
			
			throw new CamposReservaExcepcion(errorMessage + String.valueOf(valorNetoReserva) );
	}
	
	public static void validarDiaReservaValido(Date fechaReserva, String errorMessage) {

		if (fechaReserva == null) {
			throw new CampoRequeridoExcepcion(errorMessage);
		}

		int dia = Utiles.obtenerDiaSemana(fechaReserva);

		if (dia < 4 || dia == 7) {
			throw new CamposReservaExcepcion(errorMessage);
		}
	}
	
	
	

}
