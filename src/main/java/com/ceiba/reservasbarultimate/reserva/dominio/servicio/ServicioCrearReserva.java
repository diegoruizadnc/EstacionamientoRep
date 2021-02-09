package com.ceiba.reservasbarultimate.reserva.dominio.servicio;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.comun.dominio.excepciones.DatosNoEncontradosExcepcion;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCalcularValorMesaHoy;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCambiarDisponibilidadMesa;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;

@Component
public class ServicioCrearReserva {

	private final ReservaRepositorio reservaRepositorio;
	private ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa;
	private final ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy;
	private final MesaDao mesaDao;

	private static final String MESA_NO_EXISTE = "La mesa que se esta buscando NO existe";

	public ServicioCrearReserva(ReservaRepositorio reservaRepositorio,
			ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa,
			ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy, MesaDao mesaDao) {
		this.reservaRepositorio = reservaRepositorio;
		this.servicioCambiarDisponibilidadMesa = servicioCambiarDisponibilidadMesa;
		this.servicioCalcularValorMesaHoy = servicioCalcularValorMesaHoy;
		this.mesaDao = mesaDao;
	}

	public ReservaDto ejecutar(Reserva reserva) {

		MesaDto mesaDto = mesaDao.buscarMesaPorId(reserva.getIdMesa());

		if (mesaDto.getPrecioBase() == null) {
			throw new DatosNoEncontradosExcepcion(MESA_NO_EXISTE);
		}

		servicioCambiarDisponibilidadMesa.ejecutar(mesaDto);

		Long precioMesaHoy = servicioCalcularValorMesaHoy.ejecutar(mesaDto.getPrecioBase(), reserva.getFechaReserva());

		reserva.setPrecioReserva(precioMesaHoy);

		return reservaRepositorio.crear(reserva);

	}

}
