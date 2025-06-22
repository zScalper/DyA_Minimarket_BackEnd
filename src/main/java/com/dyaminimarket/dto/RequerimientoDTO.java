package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;

import java.util.List;


@Data
public class RequerimientoDTO {
	private Integer id;
	private LocalDate fecha;
	
	private List<DetalleRequerimientoDTO> detalles;
	private EstadoDTO codEstado;
	private UsuarioDTO codUsuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public List<DetalleRequerimientoDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleRequerimientoDTO> detalles) {
		this.detalles = detalles;
	}
	public EstadoDTO getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(EstadoDTO codEstado) {
		this.codEstado = codEstado;
	}
	public UsuarioDTO getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(UsuarioDTO codUsuario) {
		this.codUsuario = codUsuario;
	} 
	
}
