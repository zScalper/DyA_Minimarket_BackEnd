package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DepartamentoRepository;
import com.dyaminimarket.dao.DistritoRepository;
import com.dyaminimarket.dao.ProvinciaRepository;
import com.dyaminimarket.dao.TiendaRepository;
import com.dyaminimarket.dto.TiendaDTO;
import com.dyaminimarket.models.Tienda;

@Service
public class TiendaService {

    @Autowired private TiendaRepository repository;
    @Autowired private DepartamentoRepository departamentoRepository;
    @Autowired private ProvinciaRepository provinciaRepository;
    @Autowired private DistritoRepository distritoRepository;
    @Autowired private DepartamentoService departamentoService;
    @Autowired private ProvinciaService provinciaService;
    @Autowired private DistritoService distritoService;

    public List<TiendaDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TiendaDTO> getById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    public TiendaDTO save(TiendaDTO dto) {
        Tienda t = convertToEntity(dto);
        return convertToDTO(repository.save(t));
    }

    public TiendaDTO update(Integer id, TiendaDTO dto) {
        Optional<Tienda> existing = repository.findById(id);
        if (existing.isEmpty()) return null;

        Tienda t = existing.get();
        t.setNombre(dto.getNombre());
        t.setDireccion(dto.getDireccion());
        t.setTelefono(dto.getTelefono());

        if (dto.getCodDepartamento() != null)
            t.setCodDepartamento(departamentoRepository.findById(dto.getCodDepartamento().getId()).orElse(null));

        if (dto.getCodProvincia() != null)
            t.setCodProvincia(provinciaRepository.findById(dto.getCodProvincia().getId()).orElse(null));

        if (dto.getCodDistrito() != null)
            t.setCodDistrito(distritoRepository.findById(dto.getCodDistrito().getId()).orElse(null));

        return convertToDTO(repository.save(t));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public TiendaDTO convertToDTO(Tienda t) {
        TiendaDTO dto = new TiendaDTO();
        dto.setId(t.getId());
        dto.setNombre(t.getNombre());
        dto.setDireccion(t.getDireccion());
        dto.setTelefono(t.getTelefono());

        if (t.getCodDepartamento() != null)
            dto.setCodDepartamento(departamentoService.getById(t.getCodDepartamento().getId()).orElse(null));
        if (t.getCodProvincia() != null)
            dto.setCodProvincia(provinciaService.getById(t.getCodProvincia().getId()).orElse(null));
        if (t.getCodDistrito() != null)
            dto.setCodDistrito(distritoService.getById(t.getCodDistrito().getId()).orElse(null));

        return dto;
    }

    public Tienda convertToEntity(TiendaDTO dto) {
        Tienda t = new Tienda();
        t.setId(dto.getId());
        t.setNombre(dto.getNombre());
        t.setDireccion(dto.getDireccion());
        t.setTelefono(dto.getTelefono());

        if (dto.getCodDepartamento() != null)
            t.setCodDepartamento(departamentoRepository.findById(dto.getCodDepartamento().getId()).orElse(null));

        if (dto.getCodProvincia() != null)
            t.setCodProvincia(provinciaRepository.findById(dto.getCodProvincia().getId()).orElse(null));

        if (dto.getCodDistrito() != null)
            t.setCodDistrito(distritoRepository.findById(dto.getCodDistrito().getId()).orElse(null));

        return t;
    }
	
}
