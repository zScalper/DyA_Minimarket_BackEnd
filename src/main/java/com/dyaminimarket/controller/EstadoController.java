package com.dyaminimarket.controller;

import com.dyaminimarket.models.Estado;
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

    @GetMapping
    public ResponseEntity<List<Estado>> getEstados(){
        return ResponseEntity.ok(estadoService.getEstados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstado(@PathVariable Integer id){
        Optional<Estado> estado = estadoService.getEstadoById(id);
        return estado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody Estado estado){
        return ResponseEntity.ok(estadoService.saveEstado(estado));
    }

}
