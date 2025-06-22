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

import com.dyaminimarket.dto.CategoriaDTO;
import com.dyaminimarket.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	 @Autowired
	    private CategoriaService categoriaService;
	
	 
	  @GetMapping
	    public ResponseEntity<List<CategoriaDTO>> getCategorias() {
	        return ResponseEntity.ok(categoriaService.getCategoriasDTO());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Integer id) {
	        Optional<CategoriaDTO> dto = categoriaService.getCategoriaById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO dto) {
	        return ResponseEntity.ok(categoriaService.saveCategoriaDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
	        CategoriaDTO updated = categoriaService.updateCategoriaDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
	        if (!categoriaService.getCategoriaById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        categoriaService.deleteCategoria(id);
	        return ResponseEntity.noContent().build();
	    }
}
