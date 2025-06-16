package com.dyaminimarket.dao;

import com.dyaminimarket.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByDni(String dni);
    boolean existsByEmail(String email); // Método para verificar si el correo ya está registrado
    boolean existsByDni(String dni); // Método para verificar si el DNI ya está registrado
}


