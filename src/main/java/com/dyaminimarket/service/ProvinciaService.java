package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DepartamentoRepository;
import com.dyaminimarket.dao.ProvinciaRepository;
import com.dyaminimarket.dto.ProvinciaDTO;
import com.dyaminimarket.models.Provincia;

@Service
public class ProvinciaService {

	@Autowired private ProvinciaRepository repository;
    @Autowired private DepartamentoRepository departamentoRepository;
    @Autowired private DepartamentoService departamentoService;

    public List<ProvinciaDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProvinciaDTO> getById(Integer id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    public ProvinciaDTO save(ProvinciaDTO dto) {
        Provincia entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    public ProvinciaDTO update(Integer id, ProvinciaDTO dto) {
        Optional<Provincia> existing = repository.findById(id);
        if (existing.isEmpty()) return null;

        Provincia p = existing.get();
        p.setNombre(dto.getNombre());

        if (dto.getCodDepartamento() != null) {
            p.setCodDepartamento(departamentoRepository
                .findById(dto.getCodDepartamento().getId())
                .orElse(null));
        }

        return convertToDTO(repository.save(p));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public ProvinciaDTO convertToDTO(Provincia p) {
        ProvinciaDTO dto = new ProvinciaDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());

        if (p.getCodDepartamento() != null)
            dto.setCodDepartamento(departamentoService
                .getById(p.getCodDepartamento().getId())
                .orElse(null));

        return dto;
    }

    public Provincia convertToEntity(ProvinciaDTO dto) {
        Provincia p = new Provincia();
        p.setId(dto.getId());
        p.setNombre(dto.getNombre());

        if (dto.getCodDepartamento() != null)
            p.setCodDepartamento(departamentoRepository
                .findById(dto.getCodDepartamento().getId())
                .orElse(null));

        return p;
    }
	
}
