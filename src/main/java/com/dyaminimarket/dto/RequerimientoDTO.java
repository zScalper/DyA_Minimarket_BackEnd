package com.dyaminimarket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequerimientoDTO {
    private LocalDate fecha;
    private Integer codDetalleRequerimiento;
    private Integer codEstadoId;
    private Integer codCotizacion;
    private Integer codUsuarioId;
}
