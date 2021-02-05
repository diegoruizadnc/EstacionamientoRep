package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.dominio.ConversorMesaDtoAMesa;
import com.ceiba.reservasbarultimate.mesa.dominio.excepciones.MesaMensajeExcepcion;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.repositorio.MesaRepositorio;

@Component
public class ServicioCambiarDisponibilidadMesa {

	private final MesaDao mesaDao;
	private final MesaRepositorio mesaRepositorio;
	private final ConversorMesaDtoAMesa conversorMesaDtoAMesa;
	
	private static final String MESA_NO_DISPONIBLE="Lo sentimos, La mesa que intentas reservar NO esta disponible";


	public ServicioCambiarDisponibilidadMesa(MesaDao mesaDao, MesaRepositorio mesaRepositorio,
			ConversorMesaDtoAMesa conversorMesaDtoAMesa) {
		this.mesaDao = mesaDao;
		this.mesaRepositorio = mesaRepositorio;
		this.conversorMesaDtoAMesa = conversorMesaDtoAMesa;
	}

	public void ejecutar(Integer mesaId) {

		Mesa mesa = null;
		MesaDto mesaDto = mesaDao.buscarMesaPorId(mesaId);

		if (estaLaMesaDisponible(mesaDto))
			mesaDto.setEstaDisponible(false);
		mesa = conversorMesaDtoAMesa.ejecutar(mesaDto);

		mesaRepositorio.actualizar(mesa);
	}

	public Boolean estaLaMesaDisponible(MesaDto mesaDto) {

		if (mesaDto.getEstaDisponible())
			return true;
		else
			throw new MesaMensajeExcepcion(MESA_NO_DISPONIBLE);
	}

}
