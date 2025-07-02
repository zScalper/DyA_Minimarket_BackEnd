package com.dyaminimarket.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_cotizacion")
public class DetalleCotizacion {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_cotizacion", nullable = false)
    private Integer id;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_moneda")
    private Moneda codMoneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_forma_pago")
    private FormaPago codFormaPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_producto")
    private Producto codProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cotizacion")
    private Cotizacion cotizacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
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

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion codCotizacion) {
		this.cotizacion = codCotizacion;
	} 
    
    
}
