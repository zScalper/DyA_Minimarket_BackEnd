package com.dyaminimarket.dto;

import java.math.BigDecimal;

public class ProductoDTO {

	private Integer id;
	private String nombre;
	private Integer cantidad;
	private BigDecimal precio;
	
	private CategoriaDTO codCategoria;
	private UnidadDTO codUnidad;
	private EstadoDTO codEstado;
	private ProveedorDTO codProveedor;
	private String sku;
	

	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public CategoriaDTO getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(CategoriaDTO codCategoria) {
		this.codCategoria = codCategoria;
	}
	public UnidadDTO getCodUnidad() {
		return codUnidad;
	}
	public void setCodUnidad(UnidadDTO codUnidad) {
		this.codUnidad = codUnidad;
	}
	public EstadoDTO getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(EstadoDTO codEstado) {
		this.codEstado = codEstado;
	}
	public ProveedorDTO getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(ProveedorDTO codProveedor) {
		this.codProveedor = codProveedor;
	}
	
	
	
}
