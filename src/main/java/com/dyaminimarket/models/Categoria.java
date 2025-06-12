package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre_categoria", length = 100)
    private String nombreCategoria;

    @Size(max = 150)
    @Column(name = "detalle_categoria", length = 150)
    private String detalleCategoria;

}