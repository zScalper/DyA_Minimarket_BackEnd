package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DetalleRequerimientoRepository;
import com.dyaminimarket.dao.ProductoRepository;
import com.dyaminimarket.dto.DetalleRequerimientoDTO;
import com.dyaminimarket.models.DetalleRequerimiento;

@Service
public class DetalleRequerimientoService {

	 @Autowired private DetalleRequerimientoRepository repository;
	    @Autowired private ProductoRepository productoRepository;
	    @Autowired private ProductoService productoService;

	    public List<DetalleRequerimientoDTO> getAllDTO() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<DetalleRequerimientoDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public DetalleRequerimientoDTO saveDTO(DetalleRequerimientoDTO dto) {
	        DetalleRequerimiento entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public DetalleRequerimientoDTO updateDTO(Integer id, DetalleRequerimientoDTO dto) {
	        Optional<DetalleRequerimiento> optional = repository.findById(id);
	        if (!optional.isPresent()) return null;

	        DetalleRequerimiento existing = optional.get();
	        existing.setCantidad(dto.getCantidad());

	        if (dto.getCodProducto() != null)
	            existing.setCodProducto(productoRepository.findById(dto.getCodProducto().getId()).orElse(null));

	        return convertToDTO(repository.save(existing));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    private DetalleRequerimientoDTO convertToDTO(DetalleRequerimiento entity) {
	        DetalleRequerimientoDTO dto = new DetalleRequerimientoDTO();
	        dto.setId(entity.getId());
	        dto.setCantidad(entity.getCantidad());

	        if (entity.getCodProducto() != null)
	            dto.setCodProducto(productoService.getProductoById(entity.getCodProducto().getId()).orElse(null));

	        return dto;
	    }

	    private DetalleRequerimiento convertToEntity(DetalleRequerimientoDTO dto) {
	        DetalleRequerimiento entity = new DetalleRequerimiento();
	        entity.setId(dto.getId());
	        entity.setCantidad(dto.getCantidad());

	        if (dto.getCodProducto() != null)
	            entity.setCodProducto(productoRepository.findById(dto.getCodProducto().getId()).orElse(null));

	        return entity;
	    }
	
}
