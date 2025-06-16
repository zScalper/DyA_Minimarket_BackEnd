package com.dyaminimarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_cotizacion")
public class DetalleCotizacion {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_detalle_cotizacion", nullable = false)
	    private Integer id_detalle_cotizacion;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "cod_producto", nullable = false)
	    private Producto cod_producto;

	    @Column(name = "cantidad", nullable = false)
	    private Integer cantidad;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "cod_forma_pago", nullable = false)
	    private FormaPago cod_FormaPago;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "cod_moneda", nullable = false)
	    private Moneda cod_Moneda;

	   

		public Integer getId_detalle_cotizacion() {
			return id_detalle_cotizacion;
		}

		public void setId_detalle_cotizacion(Integer id_detalle_cotizacion) {
			this.id_detalle_cotizacion = id_detalle_cotizacion;
		}

		public Producto getCod_producto() {
			return cod_producto;
		}

		public void setCod_producto(Producto cod_producto) {
			this.cod_producto = cod_producto;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public FormaPago getCod_FormaPago() {
			return cod_FormaPago;
		}

		public void setCod_FormaPago(FormaPago cod_FormaPago) {
			this.cod_FormaPago = cod_FormaPago;
		}

		public Moneda getCod_Moneda() {
			return cod_Moneda;
		}

		public void setCod_Moneda(Moneda cod_Moneda) {
			this.cod_Moneda = cod_Moneda;
		}

	
		
	    
	
	    
	    
	    
}
