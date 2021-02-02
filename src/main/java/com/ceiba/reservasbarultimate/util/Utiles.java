package com.ceiba.reservasbarultimate.util;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.CampoRequeridoExcepcion;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.excepciones.CamposReservaExcepcion;

public class Utiles {

	private Utiles() {

	}

	public static boolean esNumerico(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static int obtenerDiaSemana(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public static Long calcularValorReserva(Date fechaReserva, int idMesa) {

		Long precioBase = 0l;
		float descuentoPorDia = 0;
		Long precioNetoReserva;

		descuentoPorDia = calcularDescuentoReservaSegunDia(fechaReserva);

		if (idMesa == 1 || idMesa == 2)
			precioBase = 200000l;
		if (idMesa >= 3 && idMesa <= 5)
			precioBase = 150000l;
		if (idMesa >= 6 && idMesa <= 9)
			precioBase = 100000l;

		precioNetoReserva = (long) (precioBase - (precioBase * descuentoPorDia));

		return precioNetoReserva;

	}

	public static float calcularDescuentoReservaSegunDia(Date fechaReserva) {
		int dia = obtenerDiaSemana(fechaReserva);
		float descuento = 0f;

		if (dia == 3)
			descuento = (float) 0.15;
		if (dia == 4)
			descuento = 0.10f;
		if (dia == 5)
			descuento = 0.05f;

		return descuento;

	}



}
