package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;



@Data
public class CotizacionDTO {
    private Integer id;
    private RequerimientoDTO codRequerimiento;  // Guardamos solo el ID en lugar de la entidad completa
    private LocalDate fecha;
    private  EstadoDTO  codEstado;  // Guardamos solo el ID de Estado
    private LocalDate fechaVencimiento;
    private  DetalleCotizacionDTO detalleCotizacion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RequerimientoDTO getCodRequerimiento() {
		return codRequerimiento;
	}
	public void setCodRequerimiento(RequerimientoDTO codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public EstadoDTO getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(EstadoDTO codEstado) {
		this.codEstado = codEstado;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public DetalleCotizacionDTO getDetalleCotizacion() {
		return detalleCotizacion;
	}
	public void setDetalleCotizacion(DetalleCotizacionDTO detalleCotizacion) {
		this.detalleCotizacion = detalleCotizacion;
	}
    
    

	
    
}
