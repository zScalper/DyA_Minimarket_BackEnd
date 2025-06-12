package com.dyaminimarket.service;

import com.dyaminimarket.dao.UsuarioRepository;
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
    public Optional<Usuario> getById(int id) {
        return usuarioRepository.findById(id);
    }
}

