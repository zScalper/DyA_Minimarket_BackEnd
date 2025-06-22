package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DetalleCotizacionRepository;
import com.dyaminimarket.dao.FormaPagoRepository;
import com.dyaminimarket.dao.MonedaRepository;
import com.dyaminimarket.dao.ProductoRepository;
import com.dyaminimarket.dto.DetalleCotizacionDTO;
import com.dyaminimarket.models.DetalleCotizacion;

@Service
public class DetalleCotizacionService {

	 @Autowired private DetalleCotizacionRepository repository;
	    @Autowired private ProductoRepository productoRepository;
	    @Autowired private FormaPagoRepository formaPagoRepository;
	    @Autowired private MonedaRepository monedaRepository;

	    @Autowired private ProductoService productoService;
	    @Autowired private FormaPagoService formaPagoService;
	    @Autowired private MonedaService monedaService;

	    public List<DetalleCotizacionDTO> getAllDTO() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<DetalleCotizacionDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public DetalleCotizacionDTO saveDTO(DetalleCotizacionDTO dto) {
	        DetalleCotizacion entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public DetalleCotizacionDTO updateDTO(Integer id, DetalleCotizacionDTO dto) {
	        Optional<DetalleCotizacion> existing = repository.findById(id);
	        if (!existing.isPresent()) return null;

	        DetalleCotizacion dc = existing.get();
	        dc.setCantidad(dto.getCantidad());

	        if (dto.getCodProducto() != null)
	            dc.setCod_producto(productoRepository.findById(dto.getCodProducto().getId()).orElse(null));

	        if (dto.getCodFormaPago() != null)
	            dc.setCod_FormaPago(formaPagoRepository.findById(dto.getCodFormaPago().getId()).orElse(null));

	        if (dto.getCodMoneda() != null)
	            dc.setCod_Moneda(monedaRepository.findById(dto.getCodMoneda().getId()).orElse(null));

	        return convertToDTO(repository.save(dc));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    private DetalleCotizacionDTO convertToDTO(DetalleCotizacion dc) {
	        DetalleCotizacionDTO dto = new DetalleCotizacionDTO();
	        dto.setIdDetalleCotizacion(dc.getId_detalle_cotizacion());
	        dto.setCantidad(dc.getCantidad());

	        if (dc.getCod_producto() != null)
	            dto.setCodProducto(productoService.getProductoById(dc.getCod_producto().getId()).orElse(null));

	        if (dc.getCod_FormaPago() != null)
	            dto.setCodFormaPago(formaPagoService.getFormaPagoById(dc.getCod_FormaPago().getId()).orElse(null));

	        if (dc.getCod_Moneda() != null)
	            dto.setCodMoneda(monedaService.getMonedaById(dc.getCod_Moneda().getId()).orElse(null));

	        return dto;
	    }

	    private DetalleCotizacion convertToEntity(DetalleCotizacionDTO dto) {
	        DetalleCotizacion entity = new DetalleCotizacion();
	        entity.setId_detalle_cotizacion(dto.getIdDetalleCotizacion());
	        entity.setCantidad(dto.getCantidad());

	        if (dto.getCodProducto() != null)
	            entity.setCod_producto(productoRepository.findById(dto.getCodProducto().getId()).orElse(null));

	        if (dto.getCodFormaPago() != null)
	            entity.setCod_FormaPago(formaPagoRepository.findById(dto.getCodFormaPago().getId()).orElse(null));

	        if (dto.getCodMoneda() != null)
	            entity.setCod_Moneda(monedaRepository.findById(dto.getCodMoneda().getId()).orElse(null));

	        return entity;
	    }
}
