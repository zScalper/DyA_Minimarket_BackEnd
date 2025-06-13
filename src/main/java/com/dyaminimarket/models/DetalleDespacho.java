package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_despacho")
public class DetalleDespacho {
    @Id
    @Column(name = "id_detalle_despacho", nullable = false)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_producto")
    private Producto codProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_despacho")
    private Despacho codDespacho;

}