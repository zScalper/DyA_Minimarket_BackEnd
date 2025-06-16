package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CotizacionDTO {
    private Integer id;
    private Integer codRequerimiento;  // Guardamos solo el ID en lugar de la entidad completa
    private LocalDate fecha;
    private Integer codEstado;  // Guardamos solo el ID de Estado
    private LocalDate fechaVencimiento;
    private Integer codMoneda;  // Guardamos solo el ID de Moneda
    private Integer codFormaPago;  // Guardamos solo el ID de FormaPago
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodRequerimiento() {
		return codRequerimiento;
	}
	public void setCodRequerimiento(Integer codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(Integer codEstado) {
		this.codEstado = codEstado;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Integer getCodMoneda() {
		return codMoneda;
	}
	public void setCodMoneda(Integer codMoneda) {
		this.codMoneda = codMoneda;
	}
	public Integer getCodFormaPago() {
		return codFormaPago;
	}
	public void setCodFormaPago(Integer codFormaPago) {
		this.codFormaPago = codFormaPago;
	}
    
}
