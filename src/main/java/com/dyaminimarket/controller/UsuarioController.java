package com.dyaminimarket.controller;

import com.dyaminimarket.dto.UsuarioDTO;
import com.dyaminimarket.models.Usuario;
import com.dyaminimarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios en formato DTO
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioService.getUsuariosDTO();
        return ResponseEntity.ok(usuariosDTO);
    }

    //  Obtener usuario por ID en formato DTO
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Integer id) {
        Optional<UsuarioDTO> usuarioDTO = usuarioService.getUsuarioById(id);
        return usuarioDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  Registrar un usuario y devolver DTO
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registerUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO savedUsuario = usuarioService.saveUsuarioDTO(usuarioDTO);
        return ResponseEntity.ok(savedUsuario);
    }

    //  Actualizar un usuario y devolver DTO
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO updatedUsuario = usuarioService.updateUsuarioDTO(id, usuarioDTO);

        if (updatedUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsuario);
    }

    //  Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        Optional<UsuarioDTO> usuario = usuarioService.getUsuarioById(id);
        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

