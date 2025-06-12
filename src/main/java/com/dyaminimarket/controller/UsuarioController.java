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

    // 🔹 Obtener todos los usuarios en formato DTO
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioService.getUsuarios()
                .stream()
                .map(usuarioService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuariosDTO);
    }

    // 🔹 Obtener usuario por ID en formato DTO
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(u -> ResponseEntity.ok(usuarioService.convertToDTO(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 🔹 Registrar un usuario y devolver DTO
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registerUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuarioService.convertToDTO(savedUsuario));
    }

}

