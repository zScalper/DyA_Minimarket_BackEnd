package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.CotizacionRepository;
import com.dyaminimarket.dao.OrdenCompraRepository;
import com.dyaminimarket.dto.OrdenCompraDTO;
import com.dyaminimarket.models.OrdenCompra;

@Service
public class OrdenCompraService {

	  @Autowired private OrdenCompraRepository repository;
	    @Autowired private CotizacionRepository cotizacionRepository;
	    @Autowired private CotizacionService cotizacionService;

	    public List<OrdenCompraDTO> getAll() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<OrdenCompraDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public OrdenCompraDTO save(OrdenCompraDTO dto) {
	        OrdenCompra entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public OrdenCompraDTO update(Integer id, OrdenCompraDTO dto) {
	        Optional<OrdenCompra> existing = repository.findById(id);
	        if (existing.isEmpty()) return null;

	        OrdenCompra oc = existing.get();
	        oc.setFecha(dto.getFecha());
	        oc.setMontoTotal(dto.getMontoTotal());

	        if (dto.getCodCotizacion() != null)
	            oc.setCodCotizacion(cotizacionRepository.findById(dto.getCodCotizacion().getId()).orElse(null));

	        return convertToDTO(repository.save(oc));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    public OrdenCompraDTO convertToDTO(OrdenCompra oc) {
	        OrdenCompraDTO dto = new OrdenCompraDTO();
	        dto.setId(oc.getId());
	        dto.setFecha(oc.getFecha());
	        dto.setMontoTotal(oc.getMontoTotal());

	        if (oc.getCodCotizacion() != null)
	            dto.setCodCotizacion(
	                cotizacionService.getById(oc.getCodCotizacion().getId()).orElse(null)
	            );

	        return dto;
	    }

	    public OrdenCompra convertToEntity(OrdenCompraDTO dto) {
	        OrdenCompra oc = new OrdenCompra();
	        oc.setId(dto.getId());
	        oc.setFecha(dto.getFecha());
	        oc.setMontoTotal(dto.getMontoTotal());

	        if (dto.getCodCotizacion() != null)
	            oc.setCodCotizacion(
	                cotizacionRepository.findById(dto.getCodCotizacion().getId()).orElse(null)
	            );

	        return oc;
	    }
	
	
}
