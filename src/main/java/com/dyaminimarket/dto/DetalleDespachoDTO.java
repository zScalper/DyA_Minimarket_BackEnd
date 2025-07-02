package com.dyaminimarket.dto;

public class DetalleDespachoDTO {
	
	    private Integer id;
	    private Integer cantidad;

	    private ProductoDTO codProducto; // Referencia ligera al producto
	    private Integer codDespachoId;   // Solo el ID del despacho, para evitar ciclos
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
		public Integer getCodDespachoId() {
			return codDespachoId;
		}
		public void setCodDespachoId(Integer codDespachoId) {
			this.codDespachoId = codDespachoId;
		}
	
	    
	
}
