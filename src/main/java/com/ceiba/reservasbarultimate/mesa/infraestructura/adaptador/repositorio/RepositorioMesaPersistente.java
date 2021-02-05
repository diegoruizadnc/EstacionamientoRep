package com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad.Mesa;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.repositorio.MesaRepositorio;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia.MesaPersistente;

@Repository
public class RepositorioMesaPersistente implements MesaRepositorio {
	
private EntityManager entityManager;
	
	public RepositorioMesaPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}

	/*@Override
	public void cambiarDisponibilidadMesa(Integer idMesa) {
		
		MesaPersistente mesaActualizarDisponibilidad= entityManager.find(MesaPersistente.class, idMesa);
		mesaActualizarDisponibilidad.setEstaDisponible(false);
		entityManager.merge(mesaActualizarDisponibilidad);
		
	}*/

	@Override
	public void actualizar(Mesa mesa) {
		MesaPersistente mesaPersistente = ConversorMesaAMesaPersistente.ejecutar(mesa);
		entityManager.merge(mesaPersistente);
		
	}

}
