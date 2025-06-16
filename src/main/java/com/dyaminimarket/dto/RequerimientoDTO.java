package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequerimientoDTO {
	private Integer id;
	private LocalDate fecha;
	private DetalleRequerimientoDTO codDetalleRequerimiento;
	private EstadoDTO codEstado;
	private CotizacionDTO codCotizacion;
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
	public DetalleRequerimientoDTO getCodDetalleRequerimiento() {
		return codDetalleRequerimiento;
	}
	public void setCodDetalleRequerimiento(DetalleRequerimientoDTO codDetalleRequerimiento) {
		this.codDetalleRequerimiento = codDetalleRequerimiento;
	}
	public EstadoDTO getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(EstadoDTO codEstado) {
		this.codEstado = codEstado;
	}
	public CotizacionDTO getCodCotizacion() {
		return codCotizacion;
	}
	public void setCodCotizacion(CotizacionDTO codCotizacion) {
		this.codCotizacion = codCotizacion;
	}
	public UsuarioDTO getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(UsuarioDTO codUsuario) {
		this.codUsuario = codUsuario;
	}
	
}
