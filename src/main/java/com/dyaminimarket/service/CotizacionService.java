package com.dyaminimarket.service;

import com.dyaminimarket.dao.CotizacionRepository;

import com.dyaminimarket.dto.CotizacionDTO;

import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.dao.RequerimientoRepository;
import com.dyaminimarket.dto.DetalleCotizacionDTO;

import com.dyaminimarket.models.Cotizacion;
import com.dyaminimarket.models.DetalleCotizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;


@Service
public class CotizacionService {

    @Autowired private CotizacionRepository cotizacionRepository;
    @Autowired private EstadoRepository estadoRepository;
    @Autowired private RequerimientoRepository requerimientoRepository;

    @Autowired private EstadoService estadoService;
    @Autowired private RequerimientoService requerimientoService;
    @Autowired private DetalleCotizacionService detalleService;

    public List<CotizacionDTO> getAllDTO() {
        return cotizacionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CotizacionDTO> getById(Integer id) {
        return cotizacionRepository.findById(id).map(this::convertToDTO);
    }

    public CotizacionDTO saveDTO(CotizacionDTO dto) {
        Cotizacion entity = convertToEntity(dto);
        entity.getDetalles().forEach(d -> d.setCotizacion(entity));
        return convertToDTO(cotizacionRepository.save(entity));
    }

    public CotizacionDTO updateDTO(Integer id, CotizacionDTO dto) {
        Optional<Cotizacion> existing = cotizacionRepository.findById(id);
        if (!existing.isPresent()) return null;

        Cotizacion entity = existing.get();
        entity.setFecha(dto.getFecha());
        entity.setFechaVencimiento(dto.getFechaVencimiento());

        if (dto.getCodEstado() != null)
            entity.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

        if (dto.getCodRequerimiento() != null)
            entity.setCodRequerimiento(requerimientoRepository.findById(dto.getCodRequerimiento().getId()).orElse(null));

        entity.getDetalles().clear();

        if (dto.getDetalles() != null) {
            for (DetalleCotizacionDTO detalleDTO : dto.getDetalles()) {
                DetalleCotizacion detalle = detalleService.convertToEntity(detalleDTO);
                detalle.setCotizacion(entity);
                entity.getDetalles().add(detalle);
            }
        }

        return convertToDTO(cotizacionRepository.save(entity));
    }

    public void delete(Integer id) {
        cotizacionRepository.deleteById(id);
    }

    public CotizacionDTO convertToDTO(Cotizacion entity) {
        CotizacionDTO dto = new CotizacionDTO();
        dto.setId(entity.getId());
        dto.setFecha(entity.getFecha());
        dto.setFechaVencimiento(entity.getFechaVencimiento());

        if (entity.getCodEstado() != null)
            dto.setCodEstado(estadoService.getById(entity.getCodEstado().getId()).orElse(null));

        if (entity.getCodRequerimiento() != null)
            dto.setCodRequerimiento(requerimientoService.getRequerimientoById(entity.getCodRequerimiento().getId()).orElse(null));

        if (entity.getDetalles() != null)
            dto.setDetalles(entity.getDetalles().stream()
                    .map(detalleService::convertToDTO)
                    .collect(Collectors.toList()));

        return dto;
    }

    public Cotizacion convertToEntity(CotizacionDTO dto) {
        Cotizacion entity = new Cotizacion();
        entity.setId(dto.getId());
        entity.setFecha(dto.getFecha());
        entity.setFechaVencimiento(dto.getFechaVencimiento());

        if (dto.getCodEstado() != null)
            entity.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

        if (dto.getCodRequerimiento() != null)
            entity.setCodRequerimiento(requerimientoRepository.findById(dto.getCodRequerimiento().getId()).orElse(null));

        if (dto.getDetalles() != null) {
            List<DetalleCotizacion> detalles = dto.getDetalles().stream()
                    .map(detalleService::convertToEntity)
                    .peek(d -> d.setCotizacion(entity))
                    .collect(Collectors.toList());
            entity.setDetalles(detalles);
        }

        return entity;
    }
}

