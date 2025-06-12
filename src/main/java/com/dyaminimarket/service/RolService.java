package com.dyaminimarket.service;

import com.dyaminimarket.dao.RolRepository;
import com.dyaminimarket.dto.RolDTO;
import com.dyaminimarket.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    //  Obtener todos los roles en formato DTO
    public List<RolDTO> getRolesDTO() {
        return rolRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //  Obtener un rol por ID en formato DTO
    public Optional<RolDTO> getRolById(Integer id) {
        return rolRepository.findById(id).map(this::convertToDTO);
    }

    //  Guardar un rol y devolver DTO
    public RolDTO saveRolDTO(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setNombre(rolDTO.getNombre());
        rol.setDescripcion(rolDTO.getDescripcion());

        Rol savedRol = rolRepository.save(rol);
        return convertToDTO(savedRol);
    }

    //  Actualizar un rol y devolver DTO
    public RolDTO updateRolDTO(Integer id, RolDTO rolDTO) {
        Optional<Rol> existingRol = rolRepository.findById(id);
        if (!existingRol.isPresent()) {
            return null;  // Opcionalmente, podrías lanzar una excepción
        }

        Rol rol = existingRol.get();
        rol.setNombre(rolDTO.getNombre());
        rol.setDescripcion(rolDTO.getDescripcion());

        Rol updatedRol = rolRepository.save(rol);
        return convertToDTO(updatedRol);
    }


    //  Eliminar un rol por ID
    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }

    //  Conversión de `Rol` a `RolDTO`
    public RolDTO convertToDTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        return dto;
    }

}
