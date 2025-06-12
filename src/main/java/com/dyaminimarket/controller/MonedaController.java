package com.dyaminimarket.controller;

import com.dyaminimarket.dto.MonedaDTO;
import com.dyaminimarket.models.Moneda;
import com.dyaminimarket.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monedas")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    // Obtener todas las monedas
    @GetMapping
    public ResponseEntity<List<MonedaDTO>> getAllMonedas() {
        List<MonedaDTO> monedasDTO = monedaService.getMonedasDTO();
        return ResponseEntity.ok(monedasDTO);
    }

    // Obtenemos una moneda por ID
    @GetMapping("/{id}")
    public ResponseEntity<MonedaDTO> getMonedaById(@PathVariable Integer id) {
        Optional<MonedaDTO> monedaDTO = monedaService.getMonedaById(id);
        return monedaDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crea una nueva moneda
    @PostMapping
    public ResponseEntity<MonedaDTO> createMoneda(@RequestBody MonedaDTO monedaDTO) {
        MonedaDTO savedMoneda = monedaService.saveMonedaDTO(monedaDTO);
        return ResponseEntity.ok(savedMoneda);
    }
    @PutMapping
    public ResponseEntity<MonedaDTO> updateMoneda(@PathVariable Integer id, @RequestBody MonedaDTO monedaDTO) {
        if (!monedaService.getMonedaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        MonedaDTO updatedMoneda = monedaService.updateMonedaDTO(id, monedaDTO);
        return ResponseEntity.ok(updatedMoneda);
    }

    //  Eliminar una moneda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoneda(@PathVariable Integer id) {
        if (!monedaService.getMonedaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        monedaService.deleteMoneda(id);
        return ResponseEntity.noContent().build();
    }

}
