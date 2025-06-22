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

import com.dyaminimarket.dto.ProveedorDTO;
import com.dyaminimarket.service.ProveedorService;

@RestController
@RequestMapping("/proveedores")

public class ProveedorController {

	 @Autowired
	    private ProveedorService proveedorService;

	    @GetMapping
	    public ResponseEntity<List<ProveedorDTO>> getProveedores() {
	        return ResponseEntity.ok(proveedorService.getProveedoresDTO());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ProveedorDTO> getProveedorById(@PathVariable Integer id) {
	        Optional<ProveedorDTO> dto = proveedorService.getProveedorById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<ProveedorDTO> createProveedor(@RequestBody ProveedorDTO dto) {
	        return ResponseEntity.ok(proveedorService.saveProveedorDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProveedorDTO> updateProveedor(@PathVariable Integer id, @RequestBody ProveedorDTO dto) {
	        ProveedorDTO updated = proveedorService.updateProveedorDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id) {
	        if (!proveedorService.getProveedorById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        proveedorService.deleteProveedor(id);
	        return ResponseEntity.noContent().build();
	    }
}
