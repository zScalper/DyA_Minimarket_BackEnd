package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @Column(name = "id_tienda", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Size(max = 150)
    @Column(name = "direccion", length = 150)
    private String direccion;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_departamento")
    private Departamento codDepartamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_provincia")
    private Provincia codProvincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_distrito")
    private Distrito codDistrito;

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

	public Departamento getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(Departamento codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public Provincia getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(Provincia codProvincia) {
		this.codProvincia = codProvincia;
	}

	public Distrito getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(Distrito codDistrito) {
		this.codDistrito = codDistrito;
	}

    
    
    
    
}