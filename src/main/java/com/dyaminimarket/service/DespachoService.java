package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DespachoRepository;
import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.dao.TiendaRepository;
import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.DespachoDTO;
import com.dyaminimarket.models.Despacho;
import com.dyaminimarket.models.DetalleDespacho;

@Service
public class DespachoService {

	  @Autowired private DespachoRepository repository;
	    @Autowired private TiendaRepository tiendaRepository;
	    @Autowired private EstadoRepository estadoRepository;
	    @Autowired private UsuarioRepository usuarioRepository;

	    @Autowired private TiendaService tiendaService;
	    @Autowired private EstadoService estadoService;
	    @Autowired private UsuarioService usuarioService;
	    @Autowired private DetalleDespachoService detalleDespachoService;

	    public List<DespachoDTO> getAll() {
	        return repository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<DespachoDTO> getById(Integer id) {
	        return repository.findById(id).map(this::convertToDTO);
	    }

	    public DespachoDTO save(DespachoDTO dto) {
	        Despacho entity = convertToEntity(dto);
	        return convertToDTO(repository.save(entity));
	    }

	    public DespachoDTO update(Integer id, DespachoDTO dto) {
	        Optional<Despacho> existing = repository.findById(id);
	        if (existing.isEmpty()) return null;

	        Despacho d = existing.get();
	        d.setFecha(dto.getFecha());

	        if (dto.getCodTienda() != null)
	            d.setCodTienda(tiendaRepository.findById(dto.getCodTienda().getId()).orElse(null));
	        if (dto.getCodEstado() != null)
	            d.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));
	        if (dto.getCodUsuario() != null)
	            d.setCodUsuario(usuarioRepository.findById(dto.getCodUsuario().getId()).orElse(null));

	        if (dto.getDetalles() != null) {
	            List<DetalleDespacho> detalles = dto.getDetalles().stream()
	                .map(detalle -> {
	                    DetalleDespacho entityDetalle = detalleDespachoService.convertToEntity(detalle);
	                    entityDetalle.setCodDespacho(d); // clave: asociar cada detalle al despacho
	                    return entityDetalle;
	                }).collect(Collectors.toList());
	            d.setDetalles(detalles);
	        }

	        return convertToDTO(repository.save(d));
	    }

	    public void delete(Integer id) {
	        repository.deleteById(id);
	    }

	    public DespachoDTO convertToDTO(Despacho d) {
	        DespachoDTO dto = new DespachoDTO();
	        dto.setId(d.getId());
	        dto.setFecha(d.getFecha());

	        if (d.getCodTienda() != null)
	            dto.setCodTienda(tiendaService.getById(d.getCodTienda().getId()).orElse(null));
	        if (d.getCodEstado() != null)
	            dto.setCodEstado(estadoService.getById(d.getCodEstado().getId()).orElse(null));
	        if (d.getCodUsuario() != null)
	            dto.setCodUsuario(usuarioService.getUsuarioById(d.getCodUsuario().getId()).orElse(null));

	        if (d.getDetalles() != null)
	            dto.setDetalles(d.getDetalles().stream()
	                .map(detalleDespachoService::convertToDTO)
	                .collect(Collectors.toList()));

	        return dto;
	    }

	    public Despacho convertToEntity(DespachoDTO dto) {
	        Despacho d = new Despacho();
	        d.setId(dto.getId());
	        d.setFecha(dto.getFecha());

	        if (dto.getCodTienda() != null)
	            d.setCodTienda(tiendaRepository.findById(dto.getCodTienda().getId()).orElse(null));
	        if (dto.getCodEstado() != null)
	            d.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));
	        if (dto.getCodUsuario() != null)
	            d.setCodUsuario(usuarioRepository.findById(dto.getCodUsuario().getId()).orElse(null));

	        if (dto.getDetalles() != null) {
	            List<DetalleDespacho> detalles = dto.getDetalles().stream()
	                .map(detalle -> {
	                    DetalleDespacho entityDetalle = detalleDespachoService.convertToEntity(detalle);
	                    entityDetalle.setCodDespacho(d);
	                    return entityDetalle;
	                }).collect(Collectors.toList());
	            d.setDetalles(detalles);
	        }

	        return d;
	    }

	    public Optional<Despacho> getEntityById(Integer id) {
	        return repository.findById(id);
	    }
	
}
