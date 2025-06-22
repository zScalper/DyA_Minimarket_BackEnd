package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dyaminimarket.dto.UnidadDTO;
import com.dyaminimarket.models.Unidad;
import com.dyaminimarket.dao.UnidadRepository;

@Service
public class UnidadService {

	   @Autowired
	    private UnidadRepository unidadRepository;

	    public List<UnidadDTO> getUnidadesDTO() {
	        return unidadRepository.findAll()
	                .stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<UnidadDTO> getUnidadById(Integer id) {
	        return unidadRepository.findById(id).map(this::convertToDTO);
	    }

	    public UnidadDTO saveUnidadDTO(UnidadDTO dto) {
	        Unidad unidad = new Unidad();
	        unidad.setId(dto.getId());
	        unidad.setUnidad(dto.getUnidad());
	        unidad.setDetalle(dto.getDetalle());
	        return convertToDTO(unidadRepository.save(unidad));
	    }

	    public UnidadDTO updateUnidadDTO(Integer id, UnidadDTO dto) {
	        Optional<Unidad> existing = unidadRepository.findById(id);
	        if (!existing.isPresent()) return null;

	        Unidad unidad = existing.get();
	        unidad.setUnidad(dto.getUnidad());
	        unidad.setDetalle(dto.getDetalle());
	        return convertToDTO(unidadRepository.save(unidad));
	    }

	    public void deleteUnidad(Integer id) {
	        unidadRepository.deleteById(id);
	    }

	    public UnidadDTO convertToDTO(Unidad unidad) {
	        UnidadDTO dto = new UnidadDTO();
	        dto.setId(unidad.getId());
	        dto.setUnidad(unidad.getUnidad());
	        dto.setDetalle(unidad.getDetalle());
	        return dto;
	    }
	
	
}
