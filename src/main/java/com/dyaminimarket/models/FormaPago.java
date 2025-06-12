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
@Table(name = "forma_pago")
public class FormaPago {
    @Id
    @Column(name = "id_forma_pago", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "forma_pago", length = 50)
    private String formaPago;

    @Size(max = 100)
    @Column(name = "detalle", length = 100)
    private String detalle;

}