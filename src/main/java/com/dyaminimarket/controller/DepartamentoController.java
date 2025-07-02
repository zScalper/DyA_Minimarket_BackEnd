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

import com.dyaminimarket.dto.DepartamentoDTO;
import com.dyaminimarket.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	  @Autowired
	    private DepartamentoService service;

	    @GetMapping
	    public ResponseEntity<List<DepartamentoDTO>> getAll() {
	        return ResponseEntity.ok(service.getAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DepartamentoDTO> getById(@PathVariable Integer id) {
	        Optional<DepartamentoDTO> dto = service.getById(id);
	        return dto.map(ResponseEntity::ok)
	                  .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<DepartamentoDTO> create(@RequestBody DepartamentoDTO dto) {
	        return ResponseEntity.ok(service.save(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<DepartamentoDTO> update(@PathVariable Integer id, @RequestBody DepartamentoDTO dto) {
	        DepartamentoDTO updated = service.update(id, dto);
	        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }	
	
	
}

