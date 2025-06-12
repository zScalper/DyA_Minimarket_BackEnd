package com.dyaminimarket.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @Column(name = "id_proveedor", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "razon_social", length = 100)
    private String razonSocial;

    @Size(max = 150)
    @Column(name = "direccion", length = 150)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_tipo")
    private TipoProveedor codTipo;

}