package com.ceiba.reservasbarultimate.mesa.dominio.servicio;


import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.comun.dominio.excepciones.ConflictoEstadoRecursoExcepcion;
import com.ceiba.reservasbarultimate.mesa.dominio.ConversorMesaDtoAMesa;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.repositorio.MesaRepositorio;

@Component
public class ServicioCambiarDisponibilidadMesa {

	private final MesaRepositorio mesaRepositorio;
	private final ConversorMesaDtoAMesa conversorMesaDtoAMesa;
	
	private static final String MESA_NO_DISPONIBLE="Lo sentimos, La mesa que intentas reservar NO esta disponible";

	public ServicioCambiarDisponibilidadMesa(MesaRepositorio mesaRepositorio,
			ConversorMesaDtoAMesa conversorMesaDtoAMesa) {
		this.mesaRepositorio = mesaRepositorio;
		this.conversorMesaDtoAMesa = conversorMesaDtoAMesa;
	}

	public Boolean ejecutar(MesaDto mesaDto) {
			
		
		if (Boolean.TRUE.equals(estaLaMesaDisponible(mesaDto) ) )
			mesaDto.setEstaDisponible(false);
		
		Mesa mesa = conversorMesaDtoAMesa.ejecutar(mesaDto);
		
		return mesaRepositorio.actualizar(mesa);
	}

	public Boolean estaLaMesaDisponible(MesaDto mesaDto) {

		if (Boolean.TRUE.equals(mesaDto.getEstaDisponible()))
			return true;
		else
			throw new ConflictoEstadoRecursoExcepcion(MESA_NO_DISPONIBLE);
	}

}
