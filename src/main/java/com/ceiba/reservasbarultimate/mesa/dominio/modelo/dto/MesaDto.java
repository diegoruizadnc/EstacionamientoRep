package com.ceiba.reservasbarultimate.mesa.dominio.modelo.dto;


public class MesaDto {
	
	private int idMesa;
	private String fila;
	private Long precioBase;
	private Long precioConDescuentoHoy;
	private Boolean estaDisponible;
	
	public MesaDto(int idMesa, String fila, Long precioBase, Boolean estaDisponible) {
		super();
		this.idMesa = idMesa;
		this.fila = fila;
		this.precioBase = precioBase;
		this.estaDisponible = estaDisponible;
	}

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

	public Long getPrecioConDescuentoHoy() {
		return precioConDescuentoHoy;
	}

	public void setPrecioConDescuentoHoy(Long precioConDescuentoHoy) {
		this.precioConDescuentoHoy = precioConDescuentoHoy;
	}

	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	
	


}
