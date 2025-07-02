package com.dyaminimarket.models;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "requerimiento")
public class Requerimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requerimiento", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_usuario")
    private Usuario codUsuario;

    
    @OneToMany(mappedBy = "requerimiento", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<DetalleRequerimiento> detalles = new ArrayList<>();



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<DetalleRequerimiento> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleRequerimiento> detalles) {
		this.detalles = detalles;
	}

	public Estado getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Estado codEstado) {
		this.codEstado = codEstado;
	}

	public Usuario getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Usuario codUsuario) {
		this.codUsuario = codUsuario;
	}

}