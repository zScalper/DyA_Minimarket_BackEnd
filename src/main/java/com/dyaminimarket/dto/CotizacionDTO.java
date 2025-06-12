package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CotizacionDTO {
    private Integer id;
    private Integer codRequerimiento;  // Guardamos solo el ID en lugar de la entidad completa
    private LocalDate fecha;
    private Integer codEstado;  // Guardamos solo el ID de Estado
    private LocalDate fechaVencimiento;
    private Integer codMoneda;  // Guardamos solo el ID de Moneda
    private Integer codFormaPago;  // Guardamos solo el ID de FormaPago
}
