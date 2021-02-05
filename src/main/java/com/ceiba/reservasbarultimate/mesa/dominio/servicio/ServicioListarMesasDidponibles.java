package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.util.Utiles;

@Component
public class ServicioListarMesasDidponibles {

	private final MesaDao mesaDao;

	public ServicioListarMesasDidponibles(MesaDao mesaDao) {
		this.mesaDao = mesaDao;
	}

	public List<MesaDto> listarMesasDisponibles() {

		List<MesaDto> listaMesaDto = null;
		List<MesaDto> listaMesaDtoConPrecioDeDescuento = null;

		listaMesaDto = mesaDao.listarMesasDisponibles();
		listaMesaDtoConPrecioDeDescuento = ponerPrecioMesaSegunDia(listaMesaDto);

		return listaMesaDtoConPrecioDeDescuento;
	}

	public List<MesaDto> ponerPrecioMesaSegunDia(List<MesaDto> listaMesaDto) {

		for (MesaDto mesadto : listaMesaDto) {
			mesadto.setPrecioConDescuentoHoy(calcularValorReserva(mesadto.getPrecioBase()));
		}

		return listaMesaDto;
	}

	public Long calcularValorReserva(Long precioBaseMesa) {

		// Long precioBase = 0l;
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
