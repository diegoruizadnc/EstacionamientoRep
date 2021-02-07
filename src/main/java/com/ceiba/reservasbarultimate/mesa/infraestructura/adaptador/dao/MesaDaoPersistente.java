package com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto.MesaDto;
import com.ceiba.reservasbarultimate.mesa.dominio.puerto.dao.MesaDao;
import com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia.MesaPersistente;

@Component
public class MesaDaoPersistente implements MesaDao {
	@SuppressWarnings("unused")
	private static final Logger LOG=LogManager.getLogger(MesaDaoPersistente.class);
	private static final String BUSCA_MESAS_DISPONIBLES = "Mesas.byEstaDisponible";
	private static final String BUSCAR_MESA_POR_ID = "Mesas.byId";
	
	private EntityManager entityManager;
	
	
	public MesaDaoPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}

	@Override
	public List<MesaDto> listarMesasDisponibles() {
		List<MesaDto> listMesaDto= new ArrayList<>();
		Query queryListMesasAct=entityManager.createNamedQuery(BUSCA_MESAS_DISPONIBLES);
		
		@SuppressWarnings("unchecked")
		List<MesaPersistente> listaMesasDisponibles = queryListMesasAct.getResultList();
		for (MesaPersistente mesaPersistente : listaMesasDisponibles) {
			listMesaDto.add(MapeoMesa.convertirToMesaDto(mesaPersistente));
		}	
			
		return listMesaDto;
	}

	@Override
	public MesaDto buscarMesaPorId(Integer idMesa) {
		MesaPersistente mesaPersistente=new MesaPersistente();
		try {
			Query query=entityManager.createNamedQuery(BUSCAR_MESA_POR_ID);
			query.setParameter("idMesa",idMesa);
			mesaPersistente=(MesaPersistente) query.getSingleResult();
		} catch (Exception e) {
			LOG.info(e);
		}
		return MapeoMesa.convertirToMesaDto(mesaPersistente);
	}



}
