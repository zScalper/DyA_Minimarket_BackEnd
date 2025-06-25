package com.dyaminimarket.service;

import com.dyaminimarket.dao.RequerimientoRepository;
import com.dyaminimarket.dto.RequerimientoDTO;
import com.dyaminimarket.dao.EstadoRepository;

import com.dyaminimarket.dao.UsuarioRepository;
import com.dyaminimarket.dto.DetalleRequerimientoDTO;

import com.dyaminimarket.models.DetalleRequerimiento;

import com.dyaminimarket.models.Requerimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class RequerimientoService {

	@Autowired
	private RequerimientoRepository repository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DetalleRequerimientoService detalleService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private UsuarioService usuarioService;

	public List<RequerimientoDTO> getAllDTO() {
		return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public Optional<RequerimientoDTO> getRequerimientoById(Integer id) {
		return repository.findById(id).map(this::convertToDTO);
	}

	public RequerimientoDTO saveDTO(RequerimientoDTO dto) {
		Requerimiento entity = convertToEntity(dto);
		entity.getDetalles().forEach(d -> d.setRequerimiento(entity));
		return convertToDTO(repository.save(entity));
	}

	public RequerimientoDTO updateDTO(Integer id, RequerimientoDTO dto) {
		Optional<Requerimiento> existing = repository.findById(id);
		if (!existing.isPresent())
			return null;

		Requerimiento entity = existing.get();
		entity.setFecha(dto.getFecha());

		if (dto.getCodEstado() != null)
			entity.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

		if (dto.getCodUsuario() != null)
			entity.setCodUsuario(usuarioRepository.findById(dto.getCodUsuario().getId()).orElse(null));

		// Eliminar los detalles antiguos
		entity.getDetalles().clear();

		// Agregar los nuevos
		if (dto.getDetalles() != null) {
			for (DetalleRequerimientoDTO detalleDTO : dto.getDetalles()) {
				DetalleRequerimiento detalle = detalleService.convertToEntity(detalleDTO);
				detalle.setRequerimiento(entity);
				entity.getDetalles().add(detalle);
			}
		}

		return convertToDTO(repository.save(entity));
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public RequerimientoDTO convertToDTO(Requerimiento entity) {
		RequerimientoDTO dto = new RequerimientoDTO();
		dto.setId(entity.getId());
		dto.setFecha(entity.getFecha());

		if (entity.getCodEstado() != null)
			dto.setCodEstado(estadoService.getById(entity.getCodEstado().getId()).orElse(null));

		if (entity.getCodUsuario() != null)
			dto.setCodUsuario(usuarioService.getUsuarioById(entity.getCodUsuario().getId()).orElse(null));

		if (entity.getDetalles() != null)
			dto.setDetalles(
					entity.getDetalles().stream().map(detalleService::convertToDTO).collect(Collectors.toList()));

		return dto;
	}

	public Requerimiento convertToEntity(RequerimientoDTO dto) {
		Requerimiento entity = new Requerimiento();
		entity.setId(dto.getId());
		entity.setFecha(dto.getFecha());

		if (dto.getCodEstado() != null)
			entity.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

		if (dto.getCodUsuario() != null)
			entity.setCodUsuario(usuarioRepository.findById(dto.getCodUsuario().getId()).orElse(null));

		if (dto.getDetalles() != null) {
			List<DetalleRequerimiento> detalles = dto.getDetalles().stream().map(detalleService::convertToEntity)
					.peek(d -> d.setRequerimiento(entity)).collect(Collectors.toList());
			entity.setDetalles(detalles);
		}

		return entity;
	}

}
