package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ceiba.reservasbarultimate.mesa.dominio.excepciones.MesaMensajeExcepcion;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;

@Component
public class ServicioListarMesasDidponibles {

	private final MesaDao mesaDao;
	private final ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy;
	
	private static final String BAR_SIN_MESAS_DISPONIBLES="Lo sentimos, todas las mesas estan reservadas para el evento de este sabado";

	public ServicioListarMesasDidponibles(MesaDao mesaDao, ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy) {
		this.mesaDao = mesaDao;
		this.servicioCalcularValorMesaHoy = servicioCalcularValorMesaHoy;
	}

	public List<MesaDto> ejecutar() {

		List<MesaDto> listaMesaDto = null;
		List<MesaDto> listaMesaDtoConPrecioDeDescuento = null;

		listaMesaDto = mesaDao.listarMesasDisponibles();
		
		if(listaMesaDto == null || listaMesaDto.isEmpty()) {
			throw new MesaMensajeExcepcion(BAR_SIN_MESAS_DISPONIBLES);
		}
		
		listaMesaDtoConPrecioDeDescuento = ponerPrecioMesaSegunDia(listaMesaDto);

		return listaMesaDtoConPrecioDeDescuento;
	}

	public List<MesaDto> ponerPrecioMesaSegunDia(List<MesaDto> listaMesaDto) {

		for (MesaDto mesadto : listaMesaDto) {
			mesadto.setPrecioConDescuentoHoy(servicioCalcularValorMesaHoy.ejecutar(mesadto.getPrecioBase()));
		}

		return listaMesaDto;
	}


}
