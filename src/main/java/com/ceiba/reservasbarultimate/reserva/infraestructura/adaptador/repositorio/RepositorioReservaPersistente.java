package com.ceiba.reservasbarultimate.reserva.infraestructura.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia.MesaPersistente;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.dto.ReservaDto;
import com.ceiba.reservasbarultimate.reserva.dominio.modelo.entidad.Reserva;
import com.ceiba.reservasbarultimate.reserva.dominio.puerto.repositorio.ReservaRepositorio;
import com.ceiba.reservasbarultimate.reserva.infraestructura.adaptador.persistencia.ReservaPersistente;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class RepositorioReservaPersistente implements ReservaRepositorio {
	@SuppressWarnings("unused")
	private static final Logger LOG=LogManager.getLogger(RepositorioReservaPersistente.class);
	
private EntityManager entityManager;
	
	public RepositorioReservaPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	
	@Override
	public ReservaDto crear(Reserva reserva) {
		ReservaPersistente reservaPersistente=MapeoReserva.convertirReservaAPersistente(reserva);
		
		entityManager.persist(reservaPersistente);
		entityManager.flush();
		
		apartarMesa(reserva.getIdMesa());
		
		return new ReservaDto(reservaPersistente.getIdReserva(),reservaPersistente.getIdMesa(),
				reservaPersistente.getIdUsuario(), reservaPersistente.getFechaReserva(),
				reservaPersistente.getCantidadPersonas(), reservaPersistente.getPrecioReserva());	
	}
	
	public void apartarMesa(int id){
		MesaPersistente mesaActualizarDisponibilidad= entityManager.find(MesaPersistente.class, id);
		mesaActualizarDisponibilidad.setEstaDisponible(false);;
		entityManager.merge(mesaActualizarDisponibilidad);
	}

}
