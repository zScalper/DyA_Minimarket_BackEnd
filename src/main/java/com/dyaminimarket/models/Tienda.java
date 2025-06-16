package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @Column(name = "id_tienda", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Size(max = 150)
    @Column(name = "direccion", length = 150)
    private String direccion;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_departamento")
    private Departamento codDepartamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_provincia")
    private Provincia codProvincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_distrito")
    private Distrito codDistrito;

}