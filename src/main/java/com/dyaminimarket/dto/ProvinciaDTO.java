package com.dyaminimarket.dto;

public class ProvinciaDTO {

	  private Integer id;
	    private String nombre;
	    private DepartamentoDTO codDepartamento;
	    
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
		public DepartamentoDTO getCodDepartamento() {
			return codDepartamento;
		}
		public void setCodDepartamento(DepartamentoDTO codDepartamento) {
			this.codDepartamento = codDepartamento;
		}
	    
	    
	
}
