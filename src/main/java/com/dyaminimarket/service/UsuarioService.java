package com.dyaminimarket.service;

import com.dyaminimarket.dao.RolRepository;
import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.RolDTO;
import com.dyaminimarket.dto.UsuarioDTO;
import com.dyaminimarket.models.Rol;
import com.dyaminimarket.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    //  Obtener todos los usuarios en formato DTO
    public List<UsuarioDTO> getUsuariosDTO() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //  Obtener un usuario por ID en formato DTO
    public Optional<UsuarioDTO> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).map(this::convertToDTO);
    }

    //  Guardar un usuario y devolver DTO
    public UsuarioDTO saveUsuarioDTO(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDni(usuarioDTO.getDni());
        usuario.setPassword(usuarioDTO.getPassword());

        // Obtener el rol desde la base de datos
        if (usuarioDTO.getRol() != null && usuarioDTO.getRol().getId() != null) {
            Optional<Rol> optionalRol = rolRepository.findById(usuarioDTO.getRol().getId());
            optionalRol.ifPresent(usuario::setRol);
        }

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(savedUsuario);
    }

    //  Actualizar un usuario y devolver DTO
    public UsuarioDTO updateUsuarioDTO(Integer id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (!existingUsuario.isPresent()) {
            return null;
        }

        Usuario usuario = existingUsuario.get();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDni(usuarioDTO.getDni());
        usuario.setPassword(usuarioDTO.getPassword());

        // Actualizar el rol si viene con ID
        if (usuarioDTO.getRol() != null && usuarioDTO.getRol().getId() != null) {
            Optional<Rol> optionalRol = rolRepository.findById(usuarioDTO.getRol().getId());
            optionalRol.ifPresent(usuario::setRol);
        }

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(updatedUsuario);
    }

    //  Eliminar un usuario por ID
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }



    //  Conversión a DTO
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
    // no se incluyo la contraseña por buenas praticas, no deberia devlover la contraseña en la respuesta aunque este encriptada
    // solo bastara con que nos diga 200 OK, la contraseña se guarda directamente en la base de datos.


    //  Conversión de `Rol` a `RolDTO`
    public RolDTO convertRolToDTO(com.dyaminimarket.models.Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        return dto;
    }

}

