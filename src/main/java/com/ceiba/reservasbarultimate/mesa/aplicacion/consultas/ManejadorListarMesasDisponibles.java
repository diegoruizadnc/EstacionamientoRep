package com.ceiba.reservasbarultimate.mesa.aplicacion.consultas;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;

@Component
public class ManejadorListarMesasDisponibles {
	
	private final MesaDao mesaDao;

    public ManejadorListarMesasDisponibles(MesaDao mesaDao){
        this.mesaDao = mesaDao;
    }

    public List<MesaDto> ejecutar(){ return this.mesaDao.listarMesasDisponibles(); }

}
