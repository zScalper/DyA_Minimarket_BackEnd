package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @Column(name = "id_proveedor", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "razon_social", length = 100)
    private String razonSocial;

    @Size(max = 150)
    @Column(name = "direccion", length = 150)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo")
    private TipoProveedor codTipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoProveedor getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(TipoProveedor codTipo) {
		this.codTipo = codTipo;
	}
    
    
}