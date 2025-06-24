package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DespachoRepository;
import com.dyaminimarket.dao.DetalleDespachoRepository;
import com.dyaminimarket.dao.ProductoRepository;
import com.dyaminimarket.dto.DetalleDespachoDTO;
import com.dyaminimarket.models.DetalleDespacho;

@Service
public class DetalleDespachoService {

	 @Autowired private DetalleDespachoRepository repository;
	    @Autowired private ProductoRepository productoRepository;
	    @Autowired private DespachoRepository despachoRepository;
	    @Autowired private ProductoService productoService;

	    public List<DetalleDespachoDTO> getAll() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<DetalleDespachoDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public DetalleDespachoDTO save(DetalleDespachoDTO dto) {
	        DetalleDespacho entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public DetalleDespachoDTO update(Integer id, DetalleDespachoDTO dto) {
	        Optional<DetalleDespacho> existing = repository.findById(id);
	        if (existing.isEmpty()) return null;

	        DetalleDespacho d = existing.get();
	        d.setCantidad(dto.getCantidad());

	        if (dto.getCodProducto() != null)
	            d.setCodProducto(productoRepository.findById(dto.getCodProducto().getId()).orElse(null));

	        if (dto.getCodDespachoId() != null)
	            d.setCodDespacho(despachoRepository.findById(dto.getCodDespachoId()).orElse(null));

	        return convertToDTO(repository.save(d));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    public DetalleDespachoDTO convertToDTO(DetalleDespacho d) {
	        DetalleDespachoDTO dto = new DetalleDespachoDTO();
	        dto.setId(d.getId());
	        dto.setCantidad(d.getCantidad());

	        if (d.getCodProducto() != null)
	            dto.setCodProducto(productoService.getProductoById(d.getCodProducto().getId()).orElse(null));

	        if (d.getCodDespacho() != null)
	            dto.setCodDespachoId(d.getCodDespacho().getId());

	        return dto;
	    }

	    public DetalleDespacho convertToEntity(DetalleDespachoDTO dto) {
	        DetalleDespacho d = new DetalleDespacho();
	        d.setId(dto.getId());
	        d.setCantidad(dto.getCantidad());

	        if (dto.getCodProducto() != null)
	            d.setCodProducto(productoRepository.findById(dto.getCodProducto().getId()).orElse(null));

	        if (dto.getCodDespachoId() != null)
	            d.setCodDespacho(despachoRepository.findById(dto.getCodDespachoId()).orElse(null));

	        return d;
	    }
  
}
