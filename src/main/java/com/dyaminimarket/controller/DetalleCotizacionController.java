package com.dyaminimarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dyaminimarket.dto.DetalleCotizacionDTO;
import com.dyaminimarket.service.DetalleCotizacionService;

@RestController
@RequestMapping("/detalle-cotizacion")
public class DetalleCotizacionController {
	
    @Autowired
    private DetalleCotizacionService service;

    @GetMapping
    public ResponseEntity<List<DetalleCotizacionDTO>> getAll() {
        return ResponseEntity.ok(service.getAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCotizacionDTO> getById(@PathVariable Integer id) {
        Optional<DetalleCotizacionDTO> dto = service.getById(id);
        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

