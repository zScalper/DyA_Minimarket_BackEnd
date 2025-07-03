package com.dyaminimarket.models;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion", nullable = false)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_requerimiento")
    private Requerimiento codRequerimiento;

    @OneToMany(mappedBy = "cotizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCotizacion> detalles = new ArrayList<>();

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

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Estado getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Estado codEstado) {
		this.codEstado = codEstado;
	}

	public Requerimiento getCodRequerimiento() {
		return codRequerimiento;
	}

	public void setCodRequerimiento(Requerimiento codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}

	public List<DetalleCotizacion> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleCotizacion> detalles) {
		this.detalles = detalles;
	}

    
	
}