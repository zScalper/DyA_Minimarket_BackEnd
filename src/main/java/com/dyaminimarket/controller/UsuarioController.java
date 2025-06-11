package com.dyaminimarket.controller;

import com.dyaminimarket.models.Usuario;
import com.dyaminimarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping("/register")
    public Usuario registerUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }
}

