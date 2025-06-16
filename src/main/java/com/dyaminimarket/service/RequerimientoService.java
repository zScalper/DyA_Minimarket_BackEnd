package com.dyaminimarket.service;

import com.dyaminimarket.dao.CotizacionRepository;
import com.dyaminimarket.dao.DetalleRequerimientoRepository;
import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.dao.RequerimientoRepository;
import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.RequerimientoDTO;
import com.dyaminimarket.models.Estado;
import com.dyaminimarket.models.Requerimiento;
import com.dyaminimarket.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequerimientoService {



    @Autowired private RequerimientoRepository repository;
    @Autowired private DetalleRequerimientoRepository detalleRepository;
    @Autowired private EstadoRepository estadoRepository;
    @Autowired private UsuarioRepository usuarioRepository;

    @Autowired private DetalleRequerimientoService detalleService;
    @Autowired private EstadoService estadoService;
    @Autowired private UsuarioService usuarioService;

    public List<RequerimientoDTO> getAllDTO() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<RequerimientoDTO> getRequerimientoById(Integer id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    public RequerimientoDTO saveDTO(RequerimientoDTO dto) {
        Requerimiento entity = convertToEntity(dto);
        return convertToDTO(repository.save(entity));
    }

    public RequerimientoDTO updateDTO(Integer id, RequerimientoDTO dto) {
        Optional<Requerimiento> existing = repository.findById(id);
        if (!existing.isPresent()) return null;

        Requerimiento req = existing.get();
        req.setFecha(dto.getFecha());

        if (dto.getCodDetalleRequerimiento() != null)
            req.setCodDetalleRequerimiento(detalleRepository.findById(dto.getCodDetalleRequerimiento().getId()).orElse(null));

        if (dto.getCodEstado() != null)
            req.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

        if (dto.getCodUsuario() != null)
            req.setCodUsuario(usuarioRepository.findById(dto.getCodUsuario().getId()).orElse(null));

        return convertToDTO(repository.save(req));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private RequerimientoDTO convertToDTO(Requerimiento entity) {
        RequerimientoDTO dto = new RequerimientoDTO();
        dto.setId(entity.getId());
        dto.setFecha(entity.getFecha());

        if (entity.getCodDetalleRequerimiento() != null)
            dto.setCodDetalleRequerimiento(detalleService.getById(entity.getCodDetalleRequerimiento().getId()).orElse(null));

        if (entity.getCodEstado() != null)
            dto.setCodEstado(estadoService.getById(entity.getCodEstado().getId()).orElse(null));

        if (entity.getCodUsuario() != null)
            dto.setCodUsuario(usuarioService.getUsuarioById(entity.getCodUsuario().getId()).orElse(null));

        return dto;
    }

    private Requerimiento convertToEntity(RequerimientoDTO dto) {
        Requerimiento entity = new Requerimiento();
        entity.setId(dto.getId());
        entity.setFecha(dto.getFecha());

        if (dto.getCodDetalleRequerimiento() != null)
            entity.setCodDetalleRequerimiento(detalleRepository.findById(dto.getCodDetalleRequerimiento().getId()).orElse(null));

        if (dto.getCodEstado() != null)
            entity.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

        if (dto.getCodUsuario() != null)
            entity.setCodUsuario(usuarioRepository.findById(dto.getCodUsuario().getId()).orElse(null));

        return entity;
    } 

}
