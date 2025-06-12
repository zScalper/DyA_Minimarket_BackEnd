package com.dyaminimarket.controller;


import com.dyaminimarket.dto.CotizacionDTO;
import com.dyaminimarket.models.Cotizacion;
import com.dyaminimarket.service.CotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cotizaciones")

public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    // Obtenemos todas las cotizaciones en formato DTO
    @GetMapping
    public ResponseEntity<List<CotizacionDTO>> getAllCotizaciones() {
        List<CotizacionDTO> cotizacionesDTO = cotizacionService.getCotizaciones()
                .stream()
                .map(cotizacionService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cotizacionesDTO);
    }



    // Obtener una cotización por ID
    @GetMapping("/{id}")
    public ResponseEntity<CotizacionDTO> getCotizacionById(@PathVariable Integer id) {
        Optional<Cotizacion> cotizacion = cotizacionService.getCotizacionById(id);
        return cotizacion.map(c -> ResponseEntity.ok(cotizacionService.convertToDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Crear una nueva cotización y devolver DTO
   @PostMapping
   public ResponseEntity<CotizacionDTO> createCotizacion(@RequestBody Cotizacion cotizacion) {
       Cotizacion savedCotizacion = cotizacionService.saveCotizacion(cotizacion);
       return ResponseEntity.ok(cotizacionService.convertToDTO(savedCotizacion));
   }

    // Actualizar una cotización existente y devuelve DTO
    @PutMapping("/{id}")
    public ResponseEntity<CotizacionDTO> updateCotizacion(@PathVariable Integer id, @RequestBody Cotizacion cotizacion) {
        if (!cotizacionService.getCotizacionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cotizacion.setId(id); // Mantiene el ID para actualizar correctamente
        Cotizacion updatedCotizacion = cotizacionService.saveCotizacion(cotizacion);
        return ResponseEntity.ok(cotizacionService.convertToDTO(updatedCotizacion));
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
