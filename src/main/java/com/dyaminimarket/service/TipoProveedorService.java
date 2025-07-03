package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.TipoProveedorRepository;
import com.dyaminimarket.dto.TipoProveedorDTO;
import com.dyaminimarket.models.TipoProveedor;

@Service
public class TipoProveedorService {

	
	@Autowired
	private TipoProveedorRepository repository;
	
	
//  Obtener todos los roles en formato DTO
	 public List<TipoProveedorDTO> getTipoProveedoresDTO() {
	        return repository.findAll()
	                .stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	 
	 public Optional<TipoProveedorDTO> getTipoProveedorById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }
	 
	 
	 public TipoProveedorDTO saveTipoProveedorDTO(TipoProveedorDTO dto) {
	        TipoProveedor entity = new TipoProveedor();
	        entity.setId(dto.getId());
	        entity.setNombre(dto.getNombre());
	        entity.setDetalle(dto.getDetalle());
	        return convertToDTO(repository.save(entity));
	    }
	 
	 
	 public TipoProveedorDTO updateTipoProveedorDTO(Integer id, TipoProveedorDTO dto) {
	        Optional<TipoProveedor> existing = repository.findById(id);
	        if (!existing.isPresent()) return null;

	        TipoProveedor tipo = existing.get();
	        tipo.setNombre(dto.getNombre());
	        tipo.setDetalle(dto.getDetalle());
	        return convertToDTO(repository.save(tipo));
	    }

	    public void deleteTipoProveedor(Integer id) {
	        repository.deleteById(id);
	    }
    
    
    //  Conversión de `TipoProveedor` a `TipoProveedorDTO`
    private TipoProveedorDTO convertToDTO(TipoProveedor tipo) {
        TipoProveedorDTO dto = new TipoProveedorDTO();
        dto.setId(tipo.getId());
        dto.setNombre(tipo.getNombre());
        dto.setDetalle(tipo.getDetalle());
        return dto;
    }

}
