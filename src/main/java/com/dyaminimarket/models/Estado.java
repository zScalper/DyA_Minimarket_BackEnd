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
@Table(name = "estado")
public class Estado {
    @Id
    @Column(name = "id_estado", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "estado", length = 50)
    private String estado;

    @Size(max = 100)
    @Column(name = "detalle_estado", length = 100)
    private String detalleEstado;

}