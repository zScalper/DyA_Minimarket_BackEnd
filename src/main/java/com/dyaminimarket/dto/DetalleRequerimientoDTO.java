package com.dyaminimarket.dto;

import lombok.Data;

@Data
public class DetalleRequerimientoDTO {

	private Integer id;
	private Integer cantidad;
	private ProductoDTO codProducto;
	private Integer idRequerimiento;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public ProductoDTO getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(ProductoDTO codProducto) {
		this.codProducto = codProducto;
	}
	public Integer getIdRequerimiento() {
		return idRequerimiento;
	}
	public void setIdRequerimiento(Integer idRequerimiento) {
		this.idRequerimiento = idRequerimiento;
	}
}
