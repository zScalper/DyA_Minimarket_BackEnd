package com.dyaminimarket.controller;


import com.dyaminimarket.dto.RequerimientoDTO;
import com.dyaminimarket.models.Requerimiento;
import com.dyaminimarket.service.RequerimientoService;
import com.dyaminimarket.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requerimientos")
public class RequerimientoController {

	 @Autowired
	    private RequerimientoService service;

	    @GetMapping
	    public ResponseEntity<List<RequerimientoDTO>> getAll() {
	        return ResponseEntity.ok(service.getAllDTO());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<RequerimientoDTO> getById(@PathVariable Integer id) {
	        Optional<RequerimientoDTO> dto = service.getRequerimientoById(id);
	        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<RequerimientoDTO> create(@RequestBody RequerimientoDTO dto) {
	        return ResponseEntity.ok(service.saveDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<RequerimientoDTO> update(@PathVariable Integer id, @RequestBody RequerimientoDTO dto) {
	        RequerimientoDTO updated = service.updateDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!service.getRequerimientoById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	  
}
