package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DepartamentoRepository;
import com.dyaminimarket.dto.DepartamentoDTO;
import com.dyaminimarket.models.Departamento;

@Service
public class DepartamentoService {

	   @Autowired
	    private DepartamentoRepository repository;

	    public List<DepartamentoDTO> getAll() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<DepartamentoDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public DepartamentoDTO save(DepartamentoDTO dto) {
	        Departamento entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public DepartamentoDTO update(Integer id, DepartamentoDTO dto) {
	        Optional<Departamento> existing = repository.findById(id);
	        if (existing.isEmpty()) return null;

	        Departamento d = existing.get();
	        d.setNombre(dto.getNombre());
	        return convertToDTO(repository.save(d));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    public DepartamentoDTO convertToDTO(Departamento d) {
	        DepartamentoDTO dto = new DepartamentoDTO();
	        dto.setId(d.getId());
	        dto.setNombre(d.getNombre());
	        return dto;
	    }

	    public Departamento convertToEntity(DepartamentoDTO dto) {
	        Departamento d = new Departamento();
	        d.setId(dto.getId());
	        d.setNombre(dto.getNombre());
	        return d;
	    }
	
}
