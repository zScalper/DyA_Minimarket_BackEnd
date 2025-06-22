package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DetalleRequerimientoRepository;
import com.dyaminimarket.dao.ProductoRepository;
import com.dyaminimarket.dto.DetalleRequerimientoDTO;
import com.dyaminimarket.models.DetalleRequerimiento;
import com.dyaminimarket.models.Producto;

@Service
public class DetalleRequerimientoService {

	@Autowired
    private ProductoRepository productoRepository;
	@Autowired
	private DetalleRequerimientoRepository detalleRepository;

    @Autowired
    private ProductoService productoService;

    public DetalleRequerimientoDTO convertToDTO(DetalleRequerimiento entity) {
        DetalleRequerimientoDTO dto = new DetalleRequerimientoDTO();
        dto.setId(entity.getId());
        dto.setCantidad(entity.getCantidad());

        if (entity.getCodProducto() != null) {
            dto.setCodProducto(productoService.getProductoById(entity.getCodProducto().getId()).orElse(null));
        }

        if (entity.getRequerimiento() != null) {
            dto.setIdRequerimiento(entity.getRequerimiento().getId());
        }

        return dto;
    }

    public DetalleRequerimiento convertToEntity(DetalleRequerimientoDTO dto) {
        DetalleRequerimiento entity = new DetalleRequerimiento();
        entity.setId(dto.getId());
        entity.setCantidad(dto.getCantidad());

        if (dto.getCodProducto() != null) {
            Optional<Producto> producto = productoRepository.findById(dto.getCodProducto().getId());
            producto.ifPresent(entity::setCodProducto);
        }

        // Requerimiento se inyecta desde RequerimientoService
        return entity;
    }
    
    public List<DetalleRequerimientoDTO> getAllDTO() {
        return detalleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DetalleRequerimientoDTO> getById(Integer id) {
        return detalleRepository.findById(id).map(this::convertToDTO);
    }
    
    
    
	
}
