package com.dyaminimarket.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String dni;
    private String password;
    private RolDTO rol;
}
