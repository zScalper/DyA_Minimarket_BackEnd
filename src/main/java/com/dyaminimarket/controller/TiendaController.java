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

import com.dyaminimarket.dto.TiendaDTO;
import com.dyaminimarket.service.TiendaService;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {

	 @Autowired
	    private TiendaService service;

	    @GetMapping
	    public ResponseEntity<List<TiendaDTO>> getAll() {
	        return ResponseEntity.ok(service.getAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TiendaDTO> getById(@PathVariable Integer id) {
	        Optional<TiendaDTO> dto = service.getById(id);
	        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<TiendaDTO> create(@RequestBody TiendaDTO dto) {
	        return ResponseEntity.ok(service.save(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<TiendaDTO> update(@PathVariable Integer id, @RequestBody TiendaDTO dto) {
	        TiendaDTO updated = service.update(id, dto);
	        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
