package com.dyaminimarket.controller;

import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.JwtResponse;
import com.dyaminimarket.dto.LoginRequest;
import com.dyaminimarket.models.Usuario;
import com.dyaminimarket.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(request.getEmail());

        if (usuario.isPresent() && usuario.get().getPassword().equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getEmail()); // Generar token con email
            return new JwtResponse(token);
        } else {
            throw new RuntimeException("Credenciales incorrectas.");
        }
    }
    
    @PutMapping("/update-password")
    public String updatePassword(@RequestParam String email, @RequestParam String newPassword) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isPresent()) {
            usuario.get().setPassword(newPassword); // Actualiza la contraseña
            usuarioRepository.save(usuario.get());
            return "Contraseña actualizada correctamente.";
        } else {
            throw new RuntimeException("Usuario no encontrado.");
        }
    }

}


