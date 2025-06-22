package com.dyaminimarket.controller;

import com.dyaminimarket.dto.RequerimientoDTO;

import com.dyaminimarket.service.RequerimientoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requerimientos")
public class RequerimientoController {

	/*
	 * // Obtendremos un Requerimiento por ID
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<RequerimientoDTO>
	 * getRequerimientoById(@PathVariable Integer id) { Optional<Requerimiento>
	 * requerimiento = requerimientoService.getRequerimientoById(id); return
	 * requerimiento.map(req ->
	 * ResponseEntity.ok(requerimientoService.convertToDTO(req))) .orElseGet(() ->
	 * ResponseEntity.notFound().build()); }
	 * 
	 * 
	 * 
	 * // Crear un nuevo requerimiento
	 * 
	 * @PostMapping public ResponseEntity<RequerimientoDTO>
	 * createRequerimiento(@RequestBody Requerimiento requerimiento) { Requerimiento
	 * savedRequerimiento = requerimientoService.saveRequerimiento(requerimiento);
	 * return
	 * ResponseEntity.ok(requerimientoService.convertToDTO(savedRequerimiento)); }
	 * 
	 * // Actualizar un requerimiento que ya existe
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<RequerimientoDTO>
	 * updateRequerimiento(@PathVariable Integer id, @RequestBody Requerimiento
	 * requerimiento) { if
	 * (!requerimientoService.getRequerimientoById(id).isPresent()) { return
	 * ResponseEntity.notFound().build(); } requerimiento.setId(id); Requerimiento
	 * updatedRequerimiento = requerimientoService.saveRequerimiento(requerimiento);
	 * return
	 * ResponseEntity.ok(requerimientoService.convertToDTO(updatedRequerimiento)); }
	 * 
	 * // Elimina un requerimiento existente
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void>
	 * deleteRequerimiento(@PathVariable Integer id) { if
	 * (!requerimientoService.getRequerimientoById(id).isPresent()) { return
	 * ResponseEntity.notFound().build(); }
	 * requerimientoService.deleteRequerimientoById(id); return
	 * ResponseEntity.noContent().build(); }
	 */
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
		if (updated == null)
			return ResponseEntity.notFound().build();
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
