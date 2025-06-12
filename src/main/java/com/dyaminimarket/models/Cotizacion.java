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
    private Requerimiento codRequerimiento;

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

}