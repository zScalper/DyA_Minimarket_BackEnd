package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_categoria")
    private Categoria codCategoria;//ya esta

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_unidad")
    private Unidad codUnidad; // ya esta

    @Column(name = "cantidad")// ya esta
    private Integer cantidad;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio; // ya esta

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado; // implementado

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_proveedor")
    private Proveedor codProveedor; // ya esta implementado.

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

	public Categoria getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(Categoria codCategoria) {
		this.codCategoria = codCategoria;
	}

	public Unidad getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(Unidad codUnidad) {
		this.codUnidad = codUnidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Estado getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Estado codEstado) {
		this.codEstado = codEstado;
	}

	public Proveedor getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(Proveedor codProveedor) {
		this.codProveedor = codProveedor;
	}
    
    
    

}