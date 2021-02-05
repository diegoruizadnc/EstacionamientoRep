package com.ceiba.reservasbarultimate.reserva.dominio.servicio;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.aplicacion.consultas.ManejadorBuscarMesaPorId;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioCambiarDisponibilidadMesa;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;

@Component
public class ServicioCrearReserva {
	
	private final ReservaRepositorio reservaRepositorio;
	private  ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa;

	
	public ServicioCrearReserva(ReservaRepositorio reservaRepositorio, ServicioCambiarDisponibilidadMesa servicioCambiarDisponibilidadMesa){
		this.reservaRepositorio=reservaRepositorio;
		this.servicioCambiarDisponibilidadMesa = servicioCambiarDisponibilidadMesa;
	}
	
	public ReservaDto ejecutar(Reserva reserva){
        
		MesaDto mesaDto = null;
		ReservaDto reservaDto=null;

		servicioCambiarDisponibilidadMesa.ejecutar(reserva.getIdMesa());
		
		System.out.println("cAMBIO DISPONIBILIDAD MESA");
		reservaDto=reservaRepositorio.crear(reserva);
			
		
		return reservaDto;
		
		}

}
