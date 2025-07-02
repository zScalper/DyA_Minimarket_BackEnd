package com.dyaminimarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyaminimarket.dto.DetalleRequerimientoDTO;
import com.dyaminimarket.service.DetalleRequerimientoService;

@RestController
@RequestMapping("/detalle-requerimiento")
public class DetalleRequerimientoController {

	
	@Autowired
    private DetalleRequerimientoService service;

    @GetMapping
    public ResponseEntity<List<DetalleRequerimientoDTO>> getAll() {
        return ResponseEntity.ok(service.getAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleRequerimientoDTO> getById(@PathVariable Integer id) {
        Optional<DetalleRequerimientoDTO> dto = service.getById(id);
        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   
}

