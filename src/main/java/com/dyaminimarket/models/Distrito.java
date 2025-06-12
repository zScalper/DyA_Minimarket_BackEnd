package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @Column(name = "id_distrito", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_provincia")
    private Provincia codProvincia;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

}