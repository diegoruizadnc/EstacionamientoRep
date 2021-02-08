package com.ceiba.reservasbarultimate.mesa.dominio.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Mesa {
	private Integer idMesa;
	private String fila;
	private Long precioBase;
	private Boolean estaDisponible;
	
	public Integer getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(Integer idMesa) {
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
