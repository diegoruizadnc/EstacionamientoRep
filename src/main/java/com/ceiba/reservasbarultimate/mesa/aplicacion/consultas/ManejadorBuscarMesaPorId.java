package com.ceiba.reservasbarultimate.mesa.aplicacion.consultas;

import org.springframework.stereotype.Component;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;

@Component
public class ManejadorBuscarMesaPorId {
	
	private final MesaDao mesaDao;

    public ManejadorBuscarMesaPorId(MesaDao mesaDao){
        this.mesaDao = mesaDao;
    }

    //public List<MesaDto> ejecutar(){ return this.mesaDao.listarMesasDisponibles(); }
    public MesaDto ejecutar(Integer mesaId){ return this.mesaDao.buscarMesaPorId(mesaId); }

}
