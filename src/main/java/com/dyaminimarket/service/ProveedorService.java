package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.ProveedorRepository;
import com.dyaminimarket.dao.TipoProveedorRepository;
import com.dyaminimarket.dto.ProveedorDTO;
import com.dyaminimarket.dto.TipoProveedorDTO;
import com.dyaminimarket.models.Proveedor;
import com.dyaminimarket.models.TipoProveedor;

@Service
public class ProveedorService {

	
	  @Autowired
	    private ProveedorRepository proveedorRepository;

	    @Autowired
	    private TipoProveedorRepository tipoProveedorRepository;
	    
	 
	    public List<ProveedorDTO> getProveedoresDTO() {
	        return proveedorRepository.findAll()
	                .stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    public Optional<ProveedorDTO> getProveedorById(Integer id) {
	        return proveedorRepository.findById(id).map(this::convertToDTO);
	    }

	    public ProveedorDTO saveProveedorDTO(ProveedorDTO dto) {
	        Proveedor proveedor = convertToEntity(dto);
	        return convertToDTO(proveedorRepository.save(proveedor));
	    }

	    public ProveedorDTO updateProveedorDTO(Integer id, ProveedorDTO dto) {
	        Optional<Proveedor> existing = proveedorRepository.findById(id);
	        if (!existing.isPresent()) return null;

	        Proveedor proveedor = existing.get();
	        proveedor.setRazonSocial(dto.getRazonSocial());
	        proveedor.setDireccion(dto.getDireccion());

	        TipoProveedor tipo = null;
	        if (dto.getCodTipo() != null && dto.getCodTipo().getId() != null) {
	            tipo = tipoProveedorRepository.findById(dto.getCodTipo().getId()).orElse(null);
	        }

	        proveedor.setCodTipo(tipo);

	        return convertToDTO(proveedorRepository.save(proveedor));
	    }

	    public void deleteProveedor(Integer id) {
	        proveedorRepository.deleteById(id);
	    }

	    private ProveedorDTO convertToDTO(Proveedor proveedor) {
	        ProveedorDTO dto = new ProveedorDTO();
	        dto.setId(proveedor.getId());
	        dto.setRazonSocial(proveedor.getRazonSocial());
	        dto.setDireccion(proveedor.getDireccion());
	        if (proveedor.getCodTipo() != null) {
	            TipoProveedor tipo = proveedor.getCodTipo();
	            TipoProveedorDTO tipoDTO = new TipoProveedorDTO();
	            tipoDTO.setId(tipo.getId());
	            tipoDTO.setNombre(tipo.getNombre());
	            tipoDTO.setDetalle(tipo.getDetalle());
	            dto.setCodTipo(tipoDTO);
	        }

	        return dto;
	    }

	    private Proveedor convertToEntity(ProveedorDTO dto) {
	        Proveedor proveedor = new Proveedor();
	        proveedor.setId(dto.getId());
	        proveedor.setRazonSocial(dto.getRazonSocial());
	        proveedor.setDireccion(dto.getDireccion());

	        TipoProveedor tipo = null;
	        if (dto.getCodTipo() != null && dto.getCodTipo().getId() != null) {
	            tipo = tipoProveedorRepository.findById(dto.getCodTipo().getId()).orElse(null);
	        }

	        proveedor.setCodTipo(tipo); 

	        return proveedor;
	    }

}
