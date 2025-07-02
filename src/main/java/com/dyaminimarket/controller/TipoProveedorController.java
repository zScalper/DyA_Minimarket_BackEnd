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

import com.dyaminimarket.dto.TipoProveedorDTO;
import com.dyaminimarket.service.TipoProveedorService;

@RestController
@RequestMapping("/tipo-proveedor")
public class TipoProveedorController {

	
	 @Autowired
	    private TipoProveedorService service;
	 
	 
	 @GetMapping
	    public ResponseEntity<List<TipoProveedorDTO>> getAll() {
	        return ResponseEntity.ok(service.getTipoProveedoresDTO());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TipoProveedorDTO> getById(@PathVariable Integer id) {
	        Optional<TipoProveedorDTO> dto = service.getTipoProveedorById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<TipoProveedorDTO> create(@RequestBody TipoProveedorDTO dto) {
	        return ResponseEntity.ok(service.saveTipoProveedorDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<TipoProveedorDTO> update(@PathVariable Integer id, @RequestBody TipoProveedorDTO dto) {
	        TipoProveedorDTO updated = service.updateTipoProveedorDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!service.getTipoProveedorById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        service.deleteTipoProveedor(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
