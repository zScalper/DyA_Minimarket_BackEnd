package com.dyaminimarket.controller;

import com.dyaminimarket.dto.RolDTO;
import com.dyaminimarket.models.Rol;
import com.dyaminimarket.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    //  Obtener todos los roles en formato DTO
    @GetMapping
    public ResponseEntity<List<RolDTO>> getRoles() {
        List<RolDTO> rolesDTO = rolService.getRolesDTO();
        return ResponseEntity.ok(rolesDTO);
    }

    //  Obtener un rol por ID en formato DTO
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable Integer id) {
        Optional<RolDTO> rolDTO = rolService.getRolById(id);
        return rolDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  Crear un nuevo rol y devolver DTO
    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody RolDTO rolDTO) {
        RolDTO savedRol = rolService.saveRolDTO(rolDTO);
        return ResponseEntity.ok(savedRol);
    }

    //  Actualizar un rol y devolver DTO
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> updateRol(@PathVariable Integer id, @RequestBody RolDTO rolDTO) {
        if (!rolService.getRolById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        RolDTO updatedRol = rolService.updateRolDTO(id, rolDTO);
        return ResponseEntity.ok(updatedRol);
    }

    //  Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        if (!rolService.getRolById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }


}
