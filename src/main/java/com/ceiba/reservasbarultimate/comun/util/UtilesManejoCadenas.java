package com.ceiba.reservasbarultimate.comun.util;

public final class UtilesManejoCadenas {
	
	private UtilesManejoCadenas() {
		
	}
	
	public static Boolean validaMaxCaracteres(String cadenaIn, Long cantidad){
		
		return cadenaIn.length() <= cantidad;
	}
	
	
	public static Boolean validaMinimaCaracteres(String cadenaIn, Long cantidad){
		
		return cadenaIn.length() >= cantidad;
	}

}
