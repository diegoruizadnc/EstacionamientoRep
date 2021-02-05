package com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
@Entity(name = "MESAS") 
@NamedQuery(name="Mesas.byEstaDisponible" , query="SELECT mes FROM MESAS mes WHERE mes.estaDisponible = true")
@NamedQuery(name="Mesas.byId", query="SELECT mes FROM MESAS mes WHERE " + " mes.idMesa = :idMesa")
@Data
public class MesaPersistente {
	@Id
	private int idMesa;
	@Column(nullable = false)
	private String fila;
	@Column(nullable = false)
	private Long precioBase;
	@Column(nullable = false)
	private Boolean estaDisponible;
}
