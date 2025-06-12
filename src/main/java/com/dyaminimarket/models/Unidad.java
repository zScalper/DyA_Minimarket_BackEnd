package com.dyaminimarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unidad")
public class Unidad {
    @Id
    @Column(name = "id_unidad", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "unidad", length = 50)
    private String unidad;

    @Size(max = 100)
    @Column(name = "detalle", length = 100)
    private String detalle;

}