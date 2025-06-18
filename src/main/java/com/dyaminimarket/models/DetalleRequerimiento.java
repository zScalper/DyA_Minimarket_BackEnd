package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_requerimiento")
public class DetalleRequerimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_requerimiento", nullable = false)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_producto")// ya esta
    private Producto codProducto;

    @Column(name = "cantidad")// ya esta
    private Integer cantidad;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_requerimiento")
    private Requerimiento requerimiento;


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


	public Requerimiento getRequerimiento() {
		return requerimiento;
	}


	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}




	

    
    
    
    

}