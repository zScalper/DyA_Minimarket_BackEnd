package com.dyaminimarket.service;

import com.dyaminimarket.dao.CotizacionRepository;
import com.dyaminimarket.dto.CotizacionDTO;
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



    public CotizacionDTO convertToDTO(Cotizacion cotizacion) {
        CotizacionDTO dto = new CotizacionDTO();
        dto.setId(cotizacion.getId());
        dto.setCodRequerimiento(cotizacion.getCodRequerimiento() != null ? cotizacion.getCodRequerimiento().getId() : null);
        dto.setFecha(cotizacion.getFecha());
        dto.setCodEstado(cotizacion.getCodEstado() != null ? cotizacion.getCodEstado().getId() : null);
        dto.setFechaVencimiento(cotizacion.getFechaVencimiento());
        dto.setCodMoneda(cotizacion.getCodMoneda() != null ? cotizacion.getCodMoneda().getId() : null);
        dto.setCodFormaPago(cotizacion.getCodFormaPago() != null ? cotizacion.getCodFormaPago().getId() : null);
        return dto;
    }


}
