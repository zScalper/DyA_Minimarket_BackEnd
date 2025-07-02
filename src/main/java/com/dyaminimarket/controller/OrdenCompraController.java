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

import com.dyaminimarket.dto.OrdenCompraDTO;
import com.dyaminimarket.service.OrdenCompraService;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController {

	  @Autowired
	    private OrdenCompraService service;

	    @GetMapping
	    public ResponseEntity<List<OrdenCompraDTO>> getAll() {
	        return ResponseEntity.ok(service.getAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<OrdenCompraDTO> getById(@PathVariable Integer id) {
	        Optional<OrdenCompraDTO> dto = service.getById(id);
	        return dto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<OrdenCompraDTO> create(@RequestBody OrdenCompraDTO dto) {
	        return ResponseEntity.ok(service.save(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<OrdenCompraDTO> update(@PathVariable Integer id, @RequestBody OrdenCompraDTO dto) {
	        OrdenCompraDTO updated = service.update(id, dto);
	        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
