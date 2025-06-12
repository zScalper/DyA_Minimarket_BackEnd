package com.dyaminimarket.service;

import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.dto.EstadoDTO;
import com.dyaminimarket.models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    // 🔹 Obtener todos los estados en formato DTO
    public List<EstadoDTO> getEstadosDTO() {
        return estadoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Obtener un estado por ID en formato DTO
    public Optional<EstadoDTO> getEstadoById(Integer id) {
        return estadoRepository.findById(id).map(this::convertToDTO);
    }

    // 🔹 Guardar un estado y devolver DTO
    public EstadoDTO saveEstadoDTO(EstadoDTO estadoDTO) {
        Estado estado = new Estado();
        estado.setId(estadoDTO.getId());
        estado.setEstado(estadoDTO.getEstado());
        estado.setDetalleEstado(estadoDTO.getDetalleEstado());

        Estado savedEstado = estadoRepository.save(estado);
        return convertToDTO(savedEstado);
    }

    // 🔹 Actualizar un estado y devolver DTO
    public EstadoDTO updateEstadoDTO(Integer id, EstadoDTO estadoDTO) {
        Optional<Estado> existingEstado = estadoRepository.findById(id);
        if (!existingEstado.isPresent()) {
            return null;  // Opcionalmente, podrías lanzar una excepción
        }

        Estado estado = existingEstado.get();
        estado.setEstado(estadoDTO.getEstado());
        estado.setDetalleEstado(estadoDTO.getDetalleEstado());

        Estado updatedEstado = estadoRepository.save(estado);
        return convertToDTO(updatedEstado);
    }

    // 🔹 Eliminar un estado por ID
    public void deleteEstado(Integer id) {
        estadoRepository.deleteById(id);
    }

    public EstadoDTO convertToDTO(Estado estado) {
        EstadoDTO dto = new EstadoDTO();
        dto.setId(estado.getId());
        dto.setEstado(estado.getEstado());
        dto.setDetalleEstado(estado.getDetalleEstado());
        return dto;
    }

}
