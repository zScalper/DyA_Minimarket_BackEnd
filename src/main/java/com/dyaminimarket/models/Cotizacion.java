package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cotizacion")
public class Cotizacion {
    @Id
    @Column(name = "id_cotizacion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "cod_requerimiento")
    private Requerimiento codRequerimiento; //falta

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_moneda")
    private Moneda codMoneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_forma_pago")
    private FormaPago codFormaPago;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_detalle_cotizacion", referencedColumnName = "id_detalle_cotizacion")
    private DetalleCotizacion codDetalleCotizacion;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Requerimiento getCodRequerimiento() {
		return codRequerimiento;
	}

	public void setCodRequerimiento(Requerimiento codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Estado getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Estado codEstado) {
		this.codEstado = codEstado;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Moneda getCodMoneda() {
		return codMoneda;
	}

	public void setCodMoneda(Moneda codMoneda) {
		this.codMoneda = codMoneda;
	}

	public FormaPago getCodFormaPago() {
		return codFormaPago;
	}

	public void setCodFormaPago(FormaPago codFormaPago) {
		this.codFormaPago = codFormaPago;
	}

	public DetalleCotizacion getCodDetalleCotizacion() {
		return codDetalleCotizacion;
	}

	public void setCodDetalleCotizacion(DetalleCotizacion codDetalleCotizacion) {
		this.codDetalleCotizacion = codDetalleCotizacion;
	}
  
	

}