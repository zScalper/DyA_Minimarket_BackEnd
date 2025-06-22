package com.dyaminimarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return dto.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetalleCotizacionDTO> create(@RequestBody DetalleCotizacionDTO dto) {
        return ResponseEntity.ok(service.saveDTO(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCotizacionDTO> update(@PathVariable Integer id, @RequestBody DetalleCotizacionDTO dto) {
        DetalleCotizacionDTO updated = service.updateDTO(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.getById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
