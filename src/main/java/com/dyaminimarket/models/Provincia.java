package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @Column(name = "id_provincia", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_departamento")
    private Departamento codDepartamento;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

}