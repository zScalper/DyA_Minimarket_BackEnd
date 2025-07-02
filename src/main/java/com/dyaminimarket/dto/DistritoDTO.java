package com.dyaminimarket.dto;

public class DistritoDTO {
	
	 private Integer id;
	    private String nombre;
	    private ProvinciaDTO codProvincia;
	    
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
		public ProvinciaDTO getCodProvincia() {
			return codProvincia;
		}
		public void setCodProvincia(ProvinciaDTO codProvincia) {
			this.codProvincia = codProvincia;
		}
	    
	    
}
