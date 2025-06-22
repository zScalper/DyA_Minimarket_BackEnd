package com.dyaminimarket.service;

import com.dyaminimarket.dao.CotizacionRepository;

import com.dyaminimarket.dto.CotizacionDTO;

import com.dyaminimarket.dao.DetalleCotizacionRepository;
import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.dao.RequerimientoRepository;
import com.dyaminimarket.dto.DetalleCotizacionDTO;

import com.dyaminimarket.models.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;


@Service
public class CotizacionService {

	   @Autowired private CotizacionRepository repository;
	    @Autowired private RequerimientoRepository requerimientoRepository;
	    @Autowired private EstadoRepository estadoRepository;
	    @Autowired private DetalleCotizacionRepository detalleRepository;

	    @Autowired private RequerimientoService requerimientoService;
	    @Autowired private EstadoService estadoService;
	    @Autowired private DetalleCotizacionService detalleService;

	    public List<CotizacionDTO> getAllDTO() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<CotizacionDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public CotizacionDTO saveDTO(CotizacionDTO dto) {
	        Cotizacion entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public CotizacionDTO updateDTO(Integer id, CotizacionDTO dto) {
	        Optional<Cotizacion> existing = repository.findById(id);
	        if (!existing.isPresent()) return null;

	        Cotizacion cot = existing.get();
	        cot.setFecha(dto.getFecha());
	        cot.setFechaVencimiento(dto.getFechaVencimiento());

	        if (dto.getCodRequerimiento() != null)
	            cot.setCodRequerimiento(requerimientoRepository.findById(dto.getCodRequerimiento().getId()).orElse(null));

	        if (dto.getCodEstado() != null)
	            cot.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

	        if (dto.getDetalleCotizacion() != null) {
	            Integer idDet = dto.getDetalleCotizacion().getIdDetalleCotizacion();
	            if (idDet != null) {
	                cot.setCodDetalleCotizacion(detalleRepository.findById(idDet).orElse(null));
	            } else {
	                // Guardar el detalle primero si es nuevo (sin ID)
	                DetalleCotizacionDTO savedDetalle = detalleService.saveDTO(dto.getDetalleCotizacion());
	                cot.setCodDetalleCotizacion(detalleRepository.findById(savedDetalle.getIdDetalleCotizacion()).orElse(null));
	            }
	        }

	        return convertToDTO(repository.save(cot));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    private CotizacionDTO convertToDTO(Cotizacion cot) {
	        CotizacionDTO dto = new CotizacionDTO();
	        dto.setId(cot.getId());
	        dto.setFecha(cot.getFecha());
	        dto.setFechaVencimiento(cot.getFechaVencimiento());

	        if (cot.getCodRequerimiento() != null)
	            dto.setCodRequerimiento(requerimientoService.getRequerimientoById(cot.getCodRequerimiento().getId()).orElse(null));

	        if (cot.getCodEstado() != null)
	            dto.setCodEstado(estadoService.getById(cot.getCodEstado().getId()).orElse(null));

	        if (cot.getCodDetalleCotizacion() != null)
	            dto.setDetalleCotizacion(detalleService.getById(cot.getCodDetalleCotizacion().getId_detalle_cotizacion()).orElse(null));

	        return dto;
	    }

	    private Cotizacion convertToEntity(CotizacionDTO dto) {
	        Cotizacion cot = new Cotizacion();
	        cot.setId(dto.getId());
	        cot.setFecha(dto.getFecha());
	        cot.setFechaVencimiento(dto.getFechaVencimiento());

	        if (dto.getCodRequerimiento() != null)
	            cot.setCodRequerimiento(requerimientoRepository.findById(dto.getCodRequerimiento().getId()).orElse(null));

	        if (dto.getCodEstado() != null)
	            cot.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

	        if (dto.getDetalleCotizacion() != null) {
	            Integer idDet = dto.getDetalleCotizacion().getIdDetalleCotizacion();
	            if (idDet != null) {
	                cot.setCodDetalleCotizacion(detalleRepository.findById(idDet).orElse(null));
	            } else {
	                // Guardar el detalle primero si es nuevo (sin ID)
	                DetalleCotizacionDTO savedDetalle = detalleService.saveDTO(dto.getDetalleCotizacion());
	                cot.setCodDetalleCotizacion(detalleRepository.findById(savedDetalle.getIdDetalleCotizacion()).orElse(null));
	            }
	        }

	        return cot;
	    }

}
