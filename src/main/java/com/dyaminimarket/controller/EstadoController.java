package com.dyaminimarket.controller;

import com.dyaminimarket.dto.EstadoDTO;
import com.dyaminimarket.models.Estado;
import com.dyaminimarket.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> getEstados() {
        List<EstadoDTO> estadosDTO = estadoService.getEstados()
                .stream()
                .map(estadoService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(estadosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> getEstadoById(@PathVariable Integer id) {
        Optional<Estado> estado = estadoService.getEstadoById(id);
        return estado.map(e -> ResponseEntity.ok(estadoService.convertToDTO(e)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> createEstado(@RequestBody Estado estado) {
        Estado savedEstado = estadoService.saveEstado(estado);
        return ResponseEntity.ok(estadoService.convertToDTO(savedEstado));
    }

}
