package com.dyaminimarket.models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_despacho")
public class DetalleDespacho {
    @Id
    @Column(name = "id_detalle_despacho", nullable = false)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_producto")

    private Producto codProducto;


    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_despacho")
    private Despacho codDespacho;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producto getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Producto codProducto) {
		this.codProducto = codProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Despacho getCodDespacho() {
		return codDespacho;
	}

	public void setCodDespacho(Despacho codDespacho) {
		this.codDespacho = codDespacho;
	}
    
    
}