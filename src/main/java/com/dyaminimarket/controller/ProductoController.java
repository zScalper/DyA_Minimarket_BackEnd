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

import com.dyaminimarket.dto.ProductoDTO;
import com.dyaminimarket.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	 @Autowired private ProductoService service;

	    @GetMapping
	    public ResponseEntity<List<ProductoDTO>> getAll() {
	        return ResponseEntity.ok(service.getAllProductos());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ProductoDTO> getById(@PathVariable Integer id) {
	        Optional<ProductoDTO> dto = service.getProductoById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    @GetMapping("/sku/{sku}")
	    public ResponseEntity<ProductoDTO> obtenerPorSku(@PathVariable String sku) {
	    	Optional<ProductoDTO> dto = service.getProductoBySku(sku);
	    	return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }


	    @PostMapping
	    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO dto) {
	        return ResponseEntity.ok(service.saveProductoDTO(dto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProductoDTO> update(@PathVariable Integer id, @RequestBody ProductoDTO dto) {
	        ProductoDTO updated = service.updateProductoDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!service.getProductoById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        service.deleteProducto(id);
	        return ResponseEntity.noContent().build();
	    }
}
