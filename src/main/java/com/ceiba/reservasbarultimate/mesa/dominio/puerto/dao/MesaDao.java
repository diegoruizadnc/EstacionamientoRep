package com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao;

import java.util.List;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;

public interface MesaDao {
	
	List<MesaDto> listarMesasDisponibles();

}
