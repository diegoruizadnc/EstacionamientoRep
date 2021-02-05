package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.util.Utiles;
@Component
public class ServicioCalcularValorMesaHoy {
	
	public ServicioCalcularValorMesaHoy(){
		
	}
	
	public Long ejecutar(Long precioBaseMesa) {

		float descuentoPorDia = 0;
		Long precioNetoReserva;
		Date fechaReserva = new Date();

		descuentoPorDia = calcularDescuentoReservaSegunDia(fechaReserva);

		precioNetoReserva = (long) (precioBaseMesa - (precioBaseMesa * descuentoPorDia));

		return precioNetoReserva;

	}

	public float calcularDescuentoReservaSegunDia(Date fechaReserva) {

		int dia = Utiles.obtenerDiaSemana(fechaReserva);
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
