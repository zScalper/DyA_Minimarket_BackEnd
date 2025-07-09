package com.dyaminimarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "forma_pago")
public class FormaPago {
    @Id
    @Column(name = "id_forma_pago", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "forma_pago", length = 50)
    private String formaPago;

    @Size(max = 100)
    @Column(name = "detalle", length = 100)
    private String detalle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
    
}