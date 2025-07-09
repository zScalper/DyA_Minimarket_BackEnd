package com.dyaminimarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;

    @Size(max = 100)
    @Column(name = "detalle_estado", length = 100)
    private String detalleEstado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDetalleEstado() {
		return detalleEstado;
	}

	public void setDetalleEstado(String detalleEstado) {
		this.detalleEstado = detalleEstado;
	}

}