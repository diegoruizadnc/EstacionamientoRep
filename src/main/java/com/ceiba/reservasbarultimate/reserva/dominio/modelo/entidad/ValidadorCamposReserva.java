package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad;


import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.CampoRequeridoExcepcion;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.CamposReservaExcepcion;
import com.ceiba.reservasbarultimate.util.Utiles;

public class ValidadorCamposReserva {
	
	private ValidadorCamposReserva(){		
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
	

	
	public static void validarDocumentoUsuarioValido(Long idUsuario, Long longitudMinimaDoc, Long longitudMaximaDoc, String errorMessage) {
		
		if (idUsuario == null) {
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		
        Boolean longitudMaximaDocumentovalida = false;
        Boolean longitudMinimaDocumentovalida = false;
        
        longitudMaximaDocumentovalida = Utiles.validaMaxCaracteres(idUsuario.toString(),longitudMaximaDoc);
        longitudMinimaDocumentovalida = Utiles.validaMinimaCaracteres(idUsuario.toString(),longitudMinimaDoc);

		if (!longitudMaximaDocumentovalida || !longitudMinimaDocumentovalida ) {
			throw new CamposReservaExcepcion(errorMessage);
		}
	}
	
	public static void validarDiaReservaValido(String errorMessage) {

		Date fechaHoy = new Date();

		int dia = Utiles.obtenerDiaSemana(fechaHoy);

		if (dia < 3 || dia == 7) {
			throw new CamposReservaExcepcion(errorMessage);
		}
	}
	
	// Ya no aplica
	
	/*public static void validarPrecioCorrecto(Long precioReserva, int idMesa, Date fechaReserva, String errorMessage){
		if(precioReserva == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
        Long valorNetoReserva ;
        valorNetoReserva = Utiles.calcularValorReserva(fechaReserva,idMesa);
		if(!precioReserva.equals(valorNetoReserva))
			
			throw new CamposReservaExcepcion(errorMessage + String.valueOf(valorNetoReserva) );
	}*/
	

	
	// Ya no aplica

}
