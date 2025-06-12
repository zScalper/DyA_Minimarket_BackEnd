package com.dyaminimarket.service;

import com.dyaminimarket.dao.RolRepository;
import com.dyaminimarket.dto.RolDTO;
import com.dyaminimarket.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> getRolById(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public RolDTO convertToDTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        return dto;
    }

}
