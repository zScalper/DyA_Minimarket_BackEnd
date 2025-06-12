package com.dyaminimarket.service;

import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.RolDTO;
import com.dyaminimarket.dto.UsuarioDTO;
import com.dyaminimarket.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    //metodo para el DTO
    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

//    public UsuarioDTO convertToDTO(Usuario usuario) {
//        UsuarioDTO dto = new UsuarioDTO();
//        dto.setId(usuario.getId());
//        dto.setNombre(usuario.getNombre());
//        dto.setApellido(usuario.getApellido());
//        dto.setEmail(usuario.getEmail());
//        dto.setTelefono(usuario.getTelefono());
//        dto.setDni(usuario.getDni());
//        dto.setRol(usuario.getRol() != null ? convertToDTO(usuario.getRol()) : null);
//        return dto;
//    }

    // 🔹 Conversión a DTO
    public UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setTelefono(usuario.getTelefono());
        dto.setEmail(usuario.getEmail());
        dto.setDni(usuario.getDni());
        dto.setRol(usuario.getRol() != null ? convertRolToDTO(usuario.getRol()) : null);
        return dto;
    }

    public RolDTO convertRolToDTO(com.dyaminimarket.models.Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        return dto;
    }

}

