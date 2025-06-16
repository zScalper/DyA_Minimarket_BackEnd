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
	        return dto.map(ResponseEntity::ok)
	                  .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<DetalleRequerimientoDTO> create(@RequestBody DetalleRequerimientoDTO dto) {
	        return ResponseEntity.ok(service.saveDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DetalleRequerimientoDTO> update(@PathVariable Integer id, @RequestBody DetalleRequerimientoDTO dto) {
	        DetalleRequerimientoDTO updated = service.updateDTO(id, dto);
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
