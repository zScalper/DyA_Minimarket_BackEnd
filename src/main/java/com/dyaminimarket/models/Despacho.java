package com.dyaminimarket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "despacho")
public class Despacho {
    @Id
    @Column(name = "id_despacho", nullable = false)
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tienda")
    private Tienda codTienda;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_detalle_despacho")
    private DetalleDespacho codDetalleDespacho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estado")
    private Estado codEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_usuario")
    private Usuario codUsuario;

}