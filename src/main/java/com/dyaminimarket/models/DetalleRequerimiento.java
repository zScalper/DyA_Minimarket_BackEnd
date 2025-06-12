package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_requerimiento")
public class DetalleRequerimiento {
    @Id
    @Column(name = "id_detalle_requerimiento", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_producto")
    private Producto codProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_requerimiento")
    private Requerimiento codRequerimiento;

}