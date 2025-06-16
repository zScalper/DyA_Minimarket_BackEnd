package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequerimientoDTO {
	private Integer id;//ya
	private LocalDate fecha;//ya
	private DetalleRequerimientoDTO codDetalleRequerimiento; // fañta
	private EstadoDTO codEstado;// ya esta
	private UsuarioDTO codUsuario; // ya esta
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
	public DetalleRequerimientoDTO getCodDetalleRequerimiento() {
		return codDetalleRequerimiento;
	}
	public void setCodDetalleRequerimiento(DetalleRequerimientoDTO codDetalleRequerimiento) {
		this.codDetalleRequerimiento = codDetalleRequerimiento;
	}
	public EstadoDTO getCodEstado() { //ya esta
		return codEstado;
	}
	public void setCodEstado(EstadoDTO codEstado) {
		this.codEstado = codEstado; // ya esta
	}
	
	
	public UsuarioDTO getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(UsuarioDTO codUsuario) {
		this.codUsuario = codUsuario;
	}
	
}
