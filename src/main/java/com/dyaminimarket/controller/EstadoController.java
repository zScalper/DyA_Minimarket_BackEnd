package com.dyaminimarket.controller;

import com.dyaminimarket.dto.EstadoDTO;
import com.dyaminimarket.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    // Obtener todos los estados en formato DTO
    @GetMapping
    public ResponseEntity<List<EstadoDTO>> getEstados() {
        List<EstadoDTO> estadosDTO = estadoService.getEstadosDTO();
        return ResponseEntity.ok(estadosDTO);
    }

    // Obtenemos un estado por ID en formato DTO
    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> getEstadoById(@PathVariable Integer id) {
        Optional<EstadoDTO> estadoDTO = estadoService.getEstadoById(id);
        return estadoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //Crear un nuevo estado y devuelve un DTO
    @PostMapping
    public ResponseEntity<EstadoDTO> createEstado(@RequestBody EstadoDTO estadoDTO) {
        EstadoDTO savedEstado = estadoService.saveEstadoDTO(estadoDTO);
        return ResponseEntity.ok(savedEstado);
    }

    //  Actualizar un estado y devolver DTO
    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> updateEstado(@PathVariable Integer id, @RequestBody EstadoDTO estadoDTO) {
        if (!estadoService.getEstadoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        EstadoDTO updatedEstado = estadoService.updateEstadoDTO(id, estadoDTO);
        return ResponseEntity.ok(updatedEstado);
    }

    // Elimina un estado y devuelve DTO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id) {
        if (!estadoService.getEstadoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estadoService.deleteEstado(id);
        return ResponseEntity.noContent().build();
    }

}
