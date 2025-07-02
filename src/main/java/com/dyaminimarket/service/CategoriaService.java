package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.CategoriaRepository;
import com.dyaminimarket.dto.CategoriaDTO;
import com.dyaminimarket.models.Categoria;

@Service
public class CategoriaService {

	
	@Autowired
	private CategoriaRepository repository;
	
	 public List<CategoriaDTO> getCategoriasDTO() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<CategoriaDTO> getCategoriaById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public CategoriaDTO saveCategoriaDTO(CategoriaDTO dto) {
	        Categoria entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public CategoriaDTO updateCategoriaDTO(Integer id, CategoriaDTO dto) {
	        Optional<Categoria> existing = repository.findById(id);
	        if (!existing.isPresent()) return null;

	        Categoria categoria = existing.get();
	        categoria.setNombreCategoria(dto.getNombreCategoria());
	        categoria.setDetalleCategoria(dto.getDetalleCategoria());
	        return convertToDTO(repository.save(categoria));
	    }

	    public void deleteCategoria(Integer id) {
	        repository.deleteById(id);
	    }

	    private CategoriaDTO convertToDTO(Categoria c) {
	        CategoriaDTO dto = new CategoriaDTO();
	        dto.setId(c.getId());
	        dto.setNombreCategoria(c.getNombreCategoria());
	        dto.setDetalleCategoria(c.getDetalleCategoria());
	        return dto;
	    }

	    private Categoria convertToEntity(CategoriaDTO dto) {
	        Categoria c = new Categoria();
	        c.setId(dto.getId());
	        c.setNombreCategoria(dto.getNombreCategoria());
	        c.setDetalleCategoria(dto.getDetalleCategoria());
	        return c;
	    }
	
}
