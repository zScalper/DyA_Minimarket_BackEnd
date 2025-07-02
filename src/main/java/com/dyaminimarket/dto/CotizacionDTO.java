package com.dyaminimarket.dto;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CotizacionDTO {
    private Integer id;
    private LocalDate fecha;
    private LocalDate fechaVencimiento;

    private EstadoDTO codEstado;
    private RequerimientoDTO codRequerimiento;

    private List<DetalleCotizacionDTO> detalles = new ArrayList<>();

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

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public EstadoDTO getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(EstadoDTO codEstado) {
		this.codEstado = codEstado;
	}

	public RequerimientoDTO getCodRequerimiento() {
		return codRequerimiento;
	}

	public void setCodRequerimiento(RequerimientoDTO codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}

	public List<DetalleCotizacionDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacionDTO> detalles) {
		this.detalles = detalles;
	}
    
    
}

