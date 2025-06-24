package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DistritoRepository;
import com.dyaminimarket.dao.ProvinciaRepository;
import com.dyaminimarket.dto.DistritoDTO;
import com.dyaminimarket.models.Distrito;

@Service
public class DistritoService {

	   @Autowired private DistritoRepository repository;
	    @Autowired private ProvinciaRepository provinciaRepository;
	    @Autowired private ProvinciaService provinciaService;

	    public List<DistritoDTO> getAll() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<DistritoDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public DistritoDTO save(DistritoDTO dto) {
	        Distrito d = convertToEntity(dto);
	        return convertToDTO(repository.save(d));
	    }

	    public DistritoDTO update(Integer id, DistritoDTO dto) {
	        Optional<Distrito> existing = repository.findById(id);
	        if (existing.isEmpty()) return null;

	        Distrito d = existing.get();
	        d.setNombre(dto.getNombre());

	        if (dto.getCodProvincia() != null) {
	            d.setCodProvincia(provinciaRepository
	                    .findById(dto.getCodProvincia().getId()).orElse(null));
	        }

	        return convertToDTO(repository.save(d));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    public DistritoDTO convertToDTO(Distrito d) {
	        DistritoDTO dto = new DistritoDTO();
	        dto.setId(d.getId());
	        dto.setNombre(d.getNombre());

	        if (d.getCodProvincia() != null) {
	            dto.setCodProvincia(
	                provinciaService.getById(d.getCodProvincia().getId()).orElse(null)
	            );
	        }

	        return dto;
	    }

	    public Distrito convertToEntity(DistritoDTO dto) {
	        Distrito d = new Distrito();
	        d.setId(dto.getId());
	        d.setNombre(dto.getNombre());

	        if (dto.getCodProvincia() != null) {
	            d.setCodProvincia(
	                provinciaRepository.findById(dto.getCodProvincia().getId()).orElse(null)
	            );
	        }

	        return d;
	    }
	
}
