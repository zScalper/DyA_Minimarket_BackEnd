package com.dyaminimarket.dto;

public class ProveedorDTO {

	private Integer id;
	private String ruc;
	private String razonSocial;
	private String direccion;
	private TipoProveedorDTO codTipo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public TipoProveedorDTO getCodTipo() {
		return codTipo;
	}
	public void setCodTipo(TipoProveedorDTO codTipo) {
		this.codTipo = codTipo;
	}
	
	
	
	
	
}
