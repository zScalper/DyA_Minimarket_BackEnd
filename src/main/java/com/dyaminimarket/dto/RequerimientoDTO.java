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
// mas adelante implementar asi:
//@Data
//public class RequerimientoDTO {
//    private LocalDate fecha;
//    private Integer codDetalleRequerimiento;
//    private EstadoDTO codEstado;
//    private CotizacionDTO  codCotizacion;
//    private UsuarioDTO  codUsuario;
//}