package com.dyaminimarket.dto;

public class DetalleCotizacionDTO {


    private Integer idDetalleCotizacion;
    private Integer cantidad;
    private ProductoDTO codProducto;
    private FormaPagoDTO codFormaPago;
    private MonedaDTO codMoneda;
  
	public Integer getIdDetalleCotizacion() {
		return idDetalleCotizacion;
	}
	public void setIdDetalleCotizacion(Integer idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
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
	public FormaPagoDTO getCodFormaPago() {
		return codFormaPago;
	}
	public void setCodFormaPago(FormaPagoDTO codFormaPago) {
		this.codFormaPago = codFormaPago;
	}
	public MonedaDTO getCodMoneda() {
		return codMoneda;
	}
	public void setCodMoneda(MonedaDTO codMoneda) {
		this.codMoneda = codMoneda;
	}
	

    
    
	
    
	
}
