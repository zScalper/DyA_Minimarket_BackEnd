package com.dyaminimarket.service;

import com.dyaminimarket.dao.CotizacionRepository;
import com.dyaminimarket.models.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;

    public List<Cotizacion> getCotizaciones(){
        return cotizacionRepository.findAll();
    }

    // Obtener una cotización por ID
    public Optional<Cotizacion> getCotizacionById(Integer id) {
        return cotizacionRepository.findById(id);
    }

    // Guardar o actualizar una cotización
    public Cotizacion saveCotizacion(Cotizacion cotizacion) {
        return cotizacionRepository.save(cotizacion);
    }

    // Eliminar una cotización por ID
    public void deleteCotizacion(Integer id) {
        cotizacionRepository.deleteById(id);
    }
}
