package com.ceiba.reservasbarultimate.reserva.infraestructura.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.ComandoReserva;
import com.ceiba.reservasbarultimate.reserva.aplicacion.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;

@RestController
@RequestMapping("/reserva")
public class ComandoControladorReserva {
	
	private final ManejadorCrearReserva manejadorCrearReserva;
	
	
	public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva){
		this.manejadorCrearReserva=manejadorCrearReserva;
	}
	
	@PostMapping("/crear")
	public ReservaDto agregaRegistroReserva(@RequestBody ComandoReserva comandoReserva){
		return manejadorCrearReserva.ejecutar(comandoReserva);
	}

}
