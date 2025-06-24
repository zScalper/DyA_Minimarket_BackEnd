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

import com.dyaminimarket.dto.DespachoDTO;
import com.dyaminimarket.service.DespachoService;

@RestController
@RequestMapping("/despachos")
public class DespachoController {

	 @Autowired
	    private DespachoService service;

	    @GetMapping
	    public ResponseEntity<List<DespachoDTO>> getAll() {
	        return ResponseEntity.ok(service.getAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DespachoDTO> getById(@PathVariable Integer id) {
	        Optional<DespachoDTO> dto = service.getById(id);
	        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<DespachoDTO> create(@RequestBody DespachoDTO dto) {
	        return ResponseEntity.ok(service.save(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DespachoDTO> update(@PathVariable Integer id, @RequestBody DespachoDTO dto) {
	        DespachoDTO updated = service.update(id, dto);
	        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
