package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "requerimiento")
public class Requerimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requerimiento", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_detalle_requerimiento")
    private DetalleRequerimiento codDetalleRequerimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cotizacion")
    private Cotizacion codCotizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_usuario")
    private Usuario codUsuario;

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

	public DetalleRequerimiento getCodDetalleRequerimiento() {
		return codDetalleRequerimiento;
	}

	public void setCodDetalleRequerimiento(DetalleRequerimiento codDetalleRequerimiento) {
		this.codDetalleRequerimiento = codDetalleRequerimiento;
	}

	public Estado getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Estado codEstado) {
		this.codEstado = codEstado;
	}

	public Cotizacion getCodCotizacion() {
		return codCotizacion;
	}

	public void setCodCotizacion(Cotizacion codCotizacion) {
		this.codCotizacion = codCotizacion;
	}

	public Usuario getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Usuario codUsuario) {
		this.codUsuario = codUsuario;
	}

}