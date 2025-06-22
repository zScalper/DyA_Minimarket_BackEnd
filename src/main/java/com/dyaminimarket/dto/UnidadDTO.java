package com.dyaminimarket.dto;

import lombok.Data;

@Data
public class UnidadDTO {

private Integer id;
private String unidad;
private  String detalle;


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUnidad() {
	return unidad;
}
public void setUnidad(String unidad) {
	this.unidad = unidad;
}
public String getDetalle() {
	return detalle;
}
public void setDetalle(String detalle) {
	this.detalle = detalle;
}
	



}
