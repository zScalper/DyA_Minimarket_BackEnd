package com.dyaminimarket.controller;


import com.dyaminimarket.models.Requerimiento;
import com.dyaminimarket.service.RequerimientoService;
import com.dyaminimarket.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requerimientos")
public class RequerimientoController {

    @Autowired
    private RequerimientoService requerimientoService;

    // Obtener la lista de todos los requerimientos
    @GetMapping
    public ResponseEntity<List<Requerimiento>> getRequerimientos(){
        return  ResponseEntity.ok(requerimientoService.getRequerimientos());
    }

    // Obtendremos un Requerimiento por ID
     @GetMapping("/{id}")
    public ResponseEntity<Requerimiento> getRequerimientoById(@PathVariable Integer id){
         Optional<Requerimiento> requerimiento = requerimientoService.getRequerimientoById(id);
         return requerimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }


     // Crear un nuevo requerimiento
     @PostMapping
    public ResponseEntity<Requerimiento> createRequerimiento(@RequestBody Requerimiento requerimiento){
        return ResponseEntity.ok(requerimientoService.saveRequerimiento(requerimiento));
     }

     // Actualizar un requerimiento que ya existe
    @PutMapping("/{id}")
    public ResponseEntity<Requerimiento> updateRequerimiento(@PathVariable Integer id, @RequestBody Requerimiento requerimiento){
        if(!requerimientoService.getRequerimientoById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        requerimiento.setId(id);
        return ResponseEntity.ok(requerimientoService.saveRequerimiento(requerimiento));
    }

    // Elimina un Requerimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Requerimiento> deleteRequerimiento(@PathVariable Integer id){
        if(!requerimientoService.getRequerimientoById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        requerimientoService.deleteRequerimientoById(id);
        return ResponseEntity.ok().build();
    }
}
