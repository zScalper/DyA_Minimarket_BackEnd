package com.dyaminimarket.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrdenCompraDTO {

	  private Integer id;
	    private LocalDate fecha;
	    private BigDecimal montoTotal;
	    private CotizacionDTO codCotizacion;
	    
	    
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
		public BigDecimal getMontoTotal() {
			return montoTotal;
		}
		public void setMontoTotal(BigDecimal montoTotal) {
			this.montoTotal = montoTotal;
		}
		public CotizacionDTO getCodCotizacion() {
			return codCotizacion;
		}
		public void setCodCotizacion(CotizacionDTO codCotizacion) {
			this.codCotizacion = codCotizacion;
		}
	
	
	    
}
