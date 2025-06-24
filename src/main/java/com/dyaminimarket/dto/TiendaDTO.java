package com.dyaminimarket.dto;

public class TiendaDTO {

	    private Integer id;
	    private String nombre;
	    private String direccion;
	    private String telefono;

	    private DepartamentoDTO codDepartamento;
	    private ProvinciaDTO codProvincia;
	    private DistritoDTO codDistrito;
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
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public DepartamentoDTO getCodDepartamento() {
			return codDepartamento;
		}
		public void setCodDepartamento(DepartamentoDTO codDepartamento) {
			this.codDepartamento = codDepartamento;
		}
		public ProvinciaDTO getCodProvincia() {
			return codProvincia;
		}
		public void setCodProvincia(ProvinciaDTO codProvincia) {
			this.codProvincia = codProvincia;
		}
		public DistritoDTO getCodDistrito() {
			return codDistrito;
		}
		public void setCodDistrito(DistritoDTO codDistrito) {
			this.codDistrito = codDistrito;
		}
	    
	    
	
}
