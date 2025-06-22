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
import com.dyaminimarket.dto.FormaPagoDTO;
import com.dyaminimarket.service.FormaPagoService;

@RestController
@RequestMapping("/formas-pago")
public class FormaPagoController {
	
	@Autowired
	private FormaPagoService formaPagoService;
	
	@GetMapping
	 public ResponseEntity<List<FormaPagoDTO>> getFormasPago() {
        return ResponseEntity.ok(formaPagoService.getFormasPagoDTO());
    }

	 @GetMapping("/{id}")
	    public ResponseEntity<FormaPagoDTO> getFormaPagoById(@PathVariable Integer id) {
	        Optional<FormaPagoDTO> dto = formaPagoService.getFormaPagoById(id);
	        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	 @PostMapping
	    public ResponseEntity<FormaPagoDTO> createFormaPago(@RequestBody FormaPagoDTO dto) {
	        return ResponseEntity.ok(formaPagoService.saveFormaPagoDTO(dto));
	    }
	
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<FormaPagoDTO> updateFormaPago(@PathVariable Integer id, @RequestBody FormaPagoDTO dto) {
	        FormaPagoDTO updated = formaPagoService.updateFormaPagoDTO(id, dto);
	        if (updated == null) return ResponseEntity.notFound().build();
	        return ResponseEntity.ok(updated);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteFormaPago(@PathVariable Integer id) {
	        if (!formaPagoService.getFormaPagoById(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        formaPagoService.deleteFormaPago(id);
	        return ResponseEntity.noContent().build();
	    }
}
