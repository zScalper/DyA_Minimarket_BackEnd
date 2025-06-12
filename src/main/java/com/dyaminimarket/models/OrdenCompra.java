package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orden_compra")
public class OrdenCompra {
    @Id
    @Column(name = "id_orden_compra", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cotizacion")
    private Cotizacion codCotizacion;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "monto_total", precision = 10, scale = 2)
    private BigDecimal montoTotal;

}