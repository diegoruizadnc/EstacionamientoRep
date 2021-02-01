package com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones;

import java.util.Calendar;
import java.util.Date;


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
			throw new CampoRequeridoExcepcion(errorMessage);
		}
	}
	
	public static void validarCantidadPersonas(Integer cantidadPersonas, String errorMessage){
		if(cantidadPersonas == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		if(cantidadPersonas <= 0 || cantidadPersonas > 5 ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
	}
	
	public static void validarPrecioCorrecto(Long precioReserva, int idMesa, Date fechaReserva, String errorMessage){
		if(precioReserva == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
        Long valorNetoReserva ;
        valorNetoReserva = calcularValorReserva(fechaReserva,idMesa);
		if(!precioReserva.equals(valorNetoReserva))
			
			throw new CampoRequeridoExcepcion(errorMessage + String.valueOf(valorNetoReserva) );
	}
	
	public static Long calcularValorReserva(Date fechaReserva, int idMesa){
		
		Long precioBase= 0l;
		float descuentoPorDia = 0;
		Long precioNetoReserva;
		
		descuentoPorDia = calcularDescuentoReservaSegunDia(fechaReserva);
		
		if(idMesa == 1 || idMesa == 2)
			precioBase = 200000l;
		if(idMesa >= 3 && idMesa <= 5)
			precioBase = 150000l;
		if(idMesa >= 6 && idMesa <= 9)
			precioBase = 100000l;
		
		precioNetoReserva = (long) (precioBase - ( precioBase * descuentoPorDia));
		
		System.out.println("DEscuento por dia" + descuentoPorDia);
		System.out.println("Precio neto reserva " + precioNetoReserva);
		
		return precioNetoReserva;
		
		
		
	}
	
	public static float calcularDescuentoReservaSegunDia(Date fechaReserva){
		int dia =  obtenerDiaSemana(fechaReserva);
		float descuento = 0f;
		
		if(dia == 3)
			descuento = (float) 0.15;
		if(dia == 4)
			descuento =  0.10f;
		if(dia == 5)
			descuento =  0.05f;
		
		return descuento;
		
	}
	
	
	
	public static void validarDiaReservaValido(Date fechaReserva, String errorMessage){
		
		if(fechaReserva == null ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
		
		
		 int dia =  obtenerDiaSemana(fechaReserva);
		 
		 System.out.println("Dia en numeros "  + dia);
		
		if( dia < 4 || dia == 7 ){
			throw new CampoRequeridoExcepcion(errorMessage);
		}
	}
	
	public static int obtenerDiaSemana(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal.get(Calendar.DAY_OF_WEEK) ;
	}
	
	/*public static void validaMaxCaracteres(String cadenaIn, String errorMessage, Long cantidad){
		if(cadenaIn.length()>cantidad){
			throw new TamanoExcedidoException(errorMessage);
		}
	}*/
	

}
