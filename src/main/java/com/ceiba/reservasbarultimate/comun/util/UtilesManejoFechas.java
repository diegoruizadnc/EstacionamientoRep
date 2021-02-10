package com.ceiba.reservasbarultimate.comun.util;

import java.util.Calendar;
import java.util.Date;

public final class UtilesManejoFechas {
	
	private UtilesManejoFechas() {
		
	}
	
	public static int obtenerDiaSemana(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

}
