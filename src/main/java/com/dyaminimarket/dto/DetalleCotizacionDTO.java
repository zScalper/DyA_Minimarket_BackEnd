package com.dyaminimarket.dto;

import java.math.BigDecimal;

public class DetalleCotizacionDTO {
    private Integer id;
    private Integer cantidad;
    private BigDecimal precioUnitario;

    private MonedaDTO codMoneda;
    private FormaPagoDTO codFormaPago;
    private ProductoDTO codProducto;
    
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
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public MonedaDTO getCodMoneda() {
		return codMoneda;
	}
	public void setCodMoneda(MonedaDTO codMoneda) {
		this.codMoneda = codMoneda;
	}
	public FormaPagoDTO getCodFormaPago() {
		return codFormaPago;
	}
	public void setCodFormaPago(FormaPagoDTO codFormaPago) {
		this.codFormaPago = codFormaPago;
	}
	public ProductoDTO getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(ProductoDTO codProducto) {
		this.codProducto = codProducto;
	}
    
    
}

