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

    @GetMapping
    public ResponseEntity<List<RolDTO>> getRoles() {
        List<RolDTO> rolesDTO = rolService.getRoles()
                .stream()
                .map(rolService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(rolesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.getRolById(id);
        return rol.map(r -> ResponseEntity.ok(rolService.convertToDTO(r)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody Rol rol) {
        Rol savedRol = rolService.saveRol(rol);
        return ResponseEntity.ok(rolService.convertToDTO(savedRol));
    }
}
