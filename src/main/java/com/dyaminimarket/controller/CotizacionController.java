package com.dyaminimarket.controller;


import com.dyaminimarket.dto.CotizacionDTO;

import com.dyaminimarket.service.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {

	 @Autowired
	    private CotizacionService service;

	    @GetMapping
	    public ResponseEntity<List<CotizacionDTO>> getAll() {
	        return ResponseEntity.ok(service.getAllDTO());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CotizacionDTO> getById(@PathVariable Integer id) {
	        Optional<CotizacionDTO> dto = service.getById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<CotizacionDTO> create(@RequestBody CotizacionDTO dto) {
	        CotizacionDTO saved = service.saveDTO(dto);
	        return ResponseEntity.ok(saved);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CotizacionDTO> update(@PathVariable Integer id, @RequestBody CotizacionDTO dto) {
	        CotizacionDTO updated = service.updateDTO(id, dto);
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
