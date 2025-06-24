package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @Column(name = "id_distrito", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_provincia")
    private Provincia codProvincia;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Provincia getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(Provincia codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
    
}