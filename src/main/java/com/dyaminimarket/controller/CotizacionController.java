package com.dyaminimarket.controller;


import com.dyaminimarket.models.Cotizacion;
import com.dyaminimarket.service.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cotizaciones")

public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    // Obtenemos todas las cotizaciones
    @GetMapping
    public ResponseEntity<List<Cotizacion>> getAllCotizaciones() {
        return ResponseEntity.ok(cotizacionService.getCotizaciones());
    }
    // Obtener una cotización por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cotizacion> getCotizacionById(@PathVariable Integer id) {
        Optional<Cotizacion> cotizacion = cotizacionService.getCotizacionById(id);
        return cotizacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Crear una nueva cotización
   @PostMapping
   public ResponseEntity<Cotizacion> createCotizacion(@RequestBody Cotizacion cotizacion) {
       return ResponseEntity.ok(cotizacionService.saveCotizacion(cotizacion));
   }

    // Actualizar una cotización existente
    @PutMapping("/{id}")
    public ResponseEntity<Cotizacion> updateCotizacion(@PathVariable Integer id, @RequestBody Cotizacion cotizacion) {
        if (!cotizacionService.getCotizacionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cotizacion.setId(id); // Mantiene el ID para actualizar correctamente
        return ResponseEntity.ok(cotizacionService.saveCotizacion(cotizacion));
    }

    // Eliminar una cotización
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCotizacion(@PathVariable Integer id) {
        if (!cotizacionService.getCotizacionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cotizacionService.deleteCotizacion(id);
        return ResponseEntity.noContent().build();
    }
}
