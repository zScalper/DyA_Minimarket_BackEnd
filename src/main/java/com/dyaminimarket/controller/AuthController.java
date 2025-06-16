package com.dyaminimarket.controller;

import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.JwtResponse;
import com.dyaminimarket.dto.LoginRequest;
import com.dyaminimarket.models.Usuario;
import com.dyaminimarket.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectamos BCryptPasswordEncoder

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioOpt.isPresent() && passwordEncoder.matches(request.getPassword(), usuarioOpt.get().getPassword())) {
            Usuario usuario = usuarioOpt.get(); // Obtén el objeto completo
            String token = jwtUtil.generateToken(usuario); // ✅ Ahora se pasa un `Usuario`
            return new JwtResponse(token);
        } else {
            throw new RuntimeException("Credenciales incorrectas.");
        }
    }
    
    @PutMapping("/update-password")
    public String updatePassword(@RequestParam String email, @RequestParam String newPassword) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isPresent()) {
            usuario.get().setPassword(passwordEncoder.encode(newPassword)); // Encriptar antes de guardar
            usuarioRepository.save(usuario.get());
            return "Contraseña actualizada correctamente.";
        } else {
            throw new RuntimeException("Usuario no encontrado.");
        }
    }

}


