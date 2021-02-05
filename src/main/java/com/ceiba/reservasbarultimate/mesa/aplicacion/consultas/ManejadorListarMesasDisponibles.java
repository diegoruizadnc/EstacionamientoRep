package com.ceiba.reservasbarultimate.mesa.aplicacion.consultas;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.dominio.servicio.ServicioListarMesasDidponibles;

@Component
public class ManejadorListarMesasDisponibles {
	
	private final MesaDao mesaDao;
	private final ServicioListarMesasDidponibles servicioListarMesasDidponibles;

    public ManejadorListarMesasDisponibles(MesaDao mesaDao, ServicioListarMesasDidponibles servicioListarMesasDidponibles){
        this.mesaDao = mesaDao;
        this.servicioListarMesasDidponibles = servicioListarMesasDidponibles;
    }

    //public List<MesaDto> ejecutar(){ return this.mesaDao.listarMesasDisponibles(); }
    public List<MesaDto> ejecutar(){ return this.servicioListarMesasDidponibles.ejecutar(); }

}
