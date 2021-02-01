package com.ceiba.reservasbarultimate.mesa.dominio.servicio;

import java.util.List;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;

public class ServicioListarMesasDidponibles {
	
	 private final MesaDao mesaDao;

	    public ServicioListarMesasDidponibles(MesaDao mesaDao) {
	        this.mesaDao = mesaDao;
	    }

	    public List<MesaDto> listarMesasDisponibles() {
	        return mesaDao.listarMesasDisponibles();
	    }

}
