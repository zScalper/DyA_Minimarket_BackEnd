package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dyaminimarket.dao.CategoriaRepository;
import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.dao.ProductoRepository;
import com.dyaminimarket.dao.ProveedorRepository;
import com.dyaminimarket.dao.UnidadRepository;
import com.dyaminimarket.dto.CategoriaDTO;
import com.dyaminimarket.dto.EstadoDTO;
import com.dyaminimarket.dto.ProductoDTO;
import com.dyaminimarket.dto.ProveedorDTO;
import com.dyaminimarket.dto.TipoProveedorDTO;
import com.dyaminimarket.dto.UnidadDTO;
import com.dyaminimarket.models.Producto;

@Service
public class ProductoService {

	@Autowired private ProductoRepository  productoRepository;
	@Autowired private CategoriaRepository  categoriaRepository;
	@Autowired private UnidadRepository   unidadRepository;
	@Autowired private EstadoRepository   estadoRepository;
	@Autowired private ProveedorRepository  proveedorRepository;
	
	  public List<ProductoDTO> getAllProductos() {
	        return productoRepository.findAll().stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<ProductoDTO> getProductoById(Integer id) {
	        return productoRepository.findById(id).map(this::convertToDTO);
	    }
	    public Optional<ProductoDTO> getProductoBySku(String sku) {
	        return productoRepository.findBySku(sku).map(this::convertToDTO);
	    }

	    public ProductoDTO saveProductoDTO(ProductoDTO dto) {
	    	if (productoRepository.existsBySku(dto.getSku())) {
	            throw new ResponseStatusException(HttpStatus.CONFLICT, "El SKU ya está registrado.");
	        }
	        Producto producto = convertToEntity(dto);
	        return convertToDTO(productoRepository.save(producto));
	    }

	    public ProductoDTO updateProductoDTO(Integer id, ProductoDTO dto) {
	        Optional<Producto> existing = productoRepository.findById(id);
	        if (!existing.isPresent()) return null;

	        Producto producto = existing.get();
	        producto.setNombre(dto.getNombre());
	        producto.setCantidad(dto.getCantidad());
	        producto.setPrecio(dto.getPrecio());
	        producto.setSku(dto.getSku());

	        producto.setCodCategoria(categoriaRepository.findById(dto.getCodCategoria().getId()).orElse(null));
	        producto.setCodUnidad(unidadRepository.findById(dto.getCodUnidad().getId()).orElse(null));
	        producto.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));
	        producto.setCodProveedor(proveedorRepository.findById(dto.getCodProveedor().getId()).orElse(null));

	        return convertToDTO(productoRepository.save(producto));
	    }

	    public void deleteProducto(Integer id) {
	        productoRepository.deleteById(id);
	    }

	    private ProductoDTO convertToDTO(Producto p) {
	        ProductoDTO dto = new ProductoDTO();
	        dto.setId(p.getId());
	        dto.setNombre(p.getNombre());
	        dto.setCantidad(p.getCantidad());
	        dto.setPrecio(p.getPrecio());
	        dto.setSku(p.getSku());

	        if (p.getCodCategoria() != null) {
	            CategoriaDTO c = new CategoriaDTO();
	            c.setId(p.getCodCategoria().getId());
	            c.setNombreCategoria(p.getCodCategoria().getNombreCategoria());
	            c.setDetalleCategoria(p.getCodCategoria().getDetalleCategoria());
	            dto.setCodCategoria(c);
	        }

	        if (p.getCodUnidad() != null) {
	            UnidadDTO u = new UnidadDTO();
	            u.setId(p.getCodUnidad().getId());
	            u.setUnidad(p.getCodUnidad().getUnidad());
	            u.setDetalle(p.getCodUnidad().getDetalle());
	            dto.setCodUnidad(u);
	        }

	        if (p.getCodEstado() != null) {
	            EstadoDTO e = new EstadoDTO();
	            e.setId(p.getCodEstado().getId());
	            e.setEstado(p.getCodEstado().getEstado());
	            e.setDetalleEstado(p.getCodEstado().getDetalleEstado()); // <-- este
	            dto.setCodEstado(e);
	        }


	        if (p.getCodProveedor() != null) {
	            ProveedorDTO prov = new ProveedorDTO();
	            prov.setId(p.getCodProveedor().getId());
	            prov.setRazonSocial(p.getCodProveedor().getRazonSocial());
	            prov.setDireccion(p.getCodProveedor().getDireccion());

	            if (p.getCodProveedor().getCodTipo() != null) {
	                TipoProveedorDTO tipoDTO = new TipoProveedorDTO();
	                tipoDTO.setId(p.getCodProveedor().getCodTipo().getId());
	                tipoDTO.setNombre(p.getCodProveedor().getCodTipo().getNombre());
	                tipoDTO.setDetalle(p.getCodProveedor().getCodTipo().getDetalle());
	                prov.setCodTipo(tipoDTO);
	            }

	            dto.setCodProveedor(prov);
	        }

	        return dto;
	    }

	    private Producto convertToEntity(ProductoDTO dto) {
	        Producto p = new Producto();
	        p.setId(dto.getId());
	        p.setNombre(dto.getNombre());
	        p.setCantidad(dto.getCantidad());
	        p.setPrecio(dto.getPrecio());
	        p.setSku(dto.getSku());

	        if (dto.getCodCategoria() != null)
	            p.setCodCategoria(categoriaRepository.findById(dto.getCodCategoria().getId()).orElse(null));

	        if (dto.getCodUnidad() != null)
	            p.setCodUnidad(unidadRepository.findById(dto.getCodUnidad().getId()).orElse(null));

	        if (dto.getCodEstado() != null)
	            p.setCodEstado(estadoRepository.findById(dto.getCodEstado().getId()).orElse(null));

	        if (dto.getCodProveedor() != null)
	            p.setCodProveedor(proveedorRepository.findById(dto.getCodProveedor().getId()).orElse(null));

	        return p;
	    }
	    
}
