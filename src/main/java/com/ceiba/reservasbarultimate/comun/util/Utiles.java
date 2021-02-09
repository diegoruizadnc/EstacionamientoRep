package com.ceiba.reservasbarultimate.comun.util;

import java.util.Calendar;
import java.util.Date;

public final class Utiles {

	private Utiles() {

	}

	
	public static Boolean validaMaxCaracteres(String cadenaIn, Long cantidad){
		
		return cadenaIn.length() < cantidad;
	}
	
	
	public static Boolean validaMinimaCaracteres(String cadenaIn, Long cantidad){
		
		return cadenaIn.length() > cantidad;
	}
	
	

	public static int obtenerDiaSemana(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}
	
	
	public static boolean esNumerico(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}



}
