package com.ceiba.reservasbarultimate.mesa.infraestructura.adaptador.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
@Entity(name = "MESAS") 
@NamedQuery(name="Mesas.byEstaDisponible" , query="SELECT mes FROM MESAS mes WHERE mes.estaDisponible = true")
@NamedQuery(name="Mesas.byId", query="SELECT mes FROM MESAS mes WHERE " + " mes.idMesa = :idMesa")

public class MesaPersistente {
	@Id
	private int idMesa;
	@Column(nullable = false)
	private String fila;
	@Column(nullable = false)
	private Long precioBase;
	@Column(nullable = false)
	private Boolean estaDisponible;
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public Long getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(Long precioBase) {
		this.precioBase = precioBase;
	}
	public Boolean getEstaDisponible() {
		return estaDisponible;
	}
	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	
	
}
