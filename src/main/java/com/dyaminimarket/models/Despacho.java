package com.dyaminimarket.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "despacho")
public class Despacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_despacho", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tienda")
    private Tienda codTienda;

    @OneToMany(mappedBy = "codDespacho", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)// un despacho puede incluir varios productos
    private List<DetalleDespacho> detalles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado;

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

	public Tienda getCodTienda() {
		return codTienda;
	}

	public void setCodTienda(Tienda codTienda) {
		this.codTienda = codTienda;
	}

	public List<DetalleDespacho> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleDespacho> detalles) {
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