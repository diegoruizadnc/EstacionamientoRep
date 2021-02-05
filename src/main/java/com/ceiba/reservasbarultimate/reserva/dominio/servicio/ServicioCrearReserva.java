package com.ceiba.reservasbarultimate.reserva.dominio.servicio;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.aplicacion.consultas.ManejadorBuscarMesaPorId;
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
	private  ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa;
	private final ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy;
	private final MesaDao mesaDao;

	
	public ServicioCrearReserva(ReservaRepositorio reservaRepositorio, ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa,
			 ServicioCalcularValorMesaHoy servicioCalcularValorMesaHoy, MesaDao mesaDao){
		this.reservaRepositorio=reservaRepositorio;
		this.servicioCambiarDisponibilidadMesa = servicioCambiarDisponibilidadMesa;
		this.servicioCalcularValorMesaHoy = servicioCalcularValorMesaHoy;
		this.mesaDao = mesaDao;
	}
	
	public ReservaDto ejecutar(Reserva reserva){
        
		MesaDto mesaDto = null;
		ReservaDto reservaDto=null;
		Long precioBaseMesa = null;

		servicioCambiarDisponibilidadMesa.ejecutar(reserva.getIdMesa());
		
		 mesaDto = mesaDao.buscarMesaPorId(reserva.getIdMesa());
		
		// seteo valor mesa hoy
		 precioBaseMesa = servicioCalcularValorMesaHoy.ejecutar(mesaDto.getPrecioBase());
		 
		 reserva.setPrecioReserva(precioBaseMesa);
		
		System.out.println("cAMBIO DISPONIBILIDAD MESA");
		reservaDto=reservaRepositorio.crear(reserva);
			
		
		return reservaDto;
		
		}

}
