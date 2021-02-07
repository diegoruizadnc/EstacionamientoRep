package com.ceiba.reservasbarultimate.mesa.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.reservasbarultimate.mesa.aplicacion.consultas.ManejadorListarMesasDisponibles;
import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;

@RestController
@RequestMapping("/mesas")
public class ConsultaControladorMesa {
	
	private final ManejadorListarMesasDisponibles manejadorListarMesasDisponibles;
	
	
	public ConsultaControladorMesa(ManejadorListarMesasDisponibles manejadorListarMesasDisponibles){
		this.manejadorListarMesasDisponibles=manejadorListarMesasDisponibles;
	}
	
	@GetMapping
	public List<MesaDto> listarMesasDisponibles(){

		return manejadorListarMesasDisponibles.ejecutar();
	}

}
