package com.dyaminimarket.dto;

import java.time.LocalDate;
import java.util.List;

public class DespachoDTO {

	    private Integer id;
	    private LocalDate fecha;

	    private TiendaDTO codTienda;
	    private List<DetalleDespachoDTO> detalles;
	    private EstadoDTO codEstado;
	    private UsuarioDTO codUsuario;
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
		public TiendaDTO getCodTienda() {
			return codTienda;
		}
		public void setCodTienda(TiendaDTO codTienda) {
			this.codTienda = codTienda;
		}
		public List<DetalleDespachoDTO> getDetalles() {
			return detalles;
		}
		public void setDetalles(List<DetalleDespachoDTO> detalles) {
			this.detalles = detalles;
		}
		public EstadoDTO getCodEstado() {
			return codEstado;
		}
		public void setCodEstado(EstadoDTO codEstado) {
			this.codEstado = codEstado;
		}
		public UsuarioDTO getCodUsuario() {
			return codUsuario;
		}
		public void setCodUsuario(UsuarioDTO codUsuario) {
			this.codUsuario = codUsuario;
		}
	
	    
	
	    
}
