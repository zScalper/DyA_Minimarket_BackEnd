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

import com.dyaminimarket.dto.UnidadDTO;
import com.dyaminimarket.service.UnidadService;

@RestController
@RequestMapping("/unidades")
public class UnidadController {

	
	 @Autowired
	    private UnidadService unidadService;

	    @GetMapping
	    public ResponseEntity<List<UnidadDTO>> getAll() {
	        return ResponseEntity.ok(unidadService.getUnidadesDTO());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<UnidadDTO> getById(@PathVariable Integer id) {
	        Optional<UnidadDTO> dto = unidadService.getUnidadById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<UnidadDTO> create(@RequestBody UnidadDTO dto) {
	        return ResponseEntity.ok(unidadService.saveUnidadDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<UnidadDTO> update(@PathVariable Integer id, @RequestBody UnidadDTO dto) {
	        UnidadDTO updated = unidadService.updateUnidadDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!unidadService.getUnidadById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        unidadService.deleteUnidad(id);
	        return ResponseEntity.noContent().build();
	    }
}
