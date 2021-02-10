package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.comun.util.UtilesManejoFechas;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ServicioCalcularValorMesaHoy {

	public Long ejecutar(Long precioBaseMesa, Date fechaReserva) {

		float descuentoPorDia = calcularDescuentoReservaSegunDia(fechaReserva);

		return (long) (precioBaseMesa - (precioBaseMesa * descuentoPorDia));

	}

	public float calcularDescuentoReservaSegunDia(Date fechaReserva) {

		float descuento = 0f;

		int dia = UtilesManejoFechas.obtenerDiaSemana(fechaReserva);

		if (dia == 3)
			descuento = (float) 0.15;
		if (dia == 4)
			descuento = 0.10f;
		if (dia == 5)
			descuento = 0.05f;

		return descuento;

	}

}
