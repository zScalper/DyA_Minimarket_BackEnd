package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.FormaPagoRepository;
import com.dyaminimarket.dto.FormaPagoDTO;
import com.dyaminimarket.models.FormaPago;

@Service
public class FormaPagoService {

	@Autowired
	private FormaPagoRepository formaPagoRepository;
	
	 public List<FormaPagoDTO> getFormasPagoDTO() {
	        return formaPagoRepository.findAll()
	                .stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    public Optional<FormaPagoDTO> getFormaPagoById(Integer id) {
	        return formaPagoRepository.findById(id).map(this::convertToDTO);
	    }

	    public FormaPagoDTO saveFormaPagoDTO(FormaPagoDTO dto) {
	        FormaPago entity = new FormaPago();
	        entity.setId(dto.getId());
	        entity.setFormaPago(dto.getFormaPago());
	        entity.setDetalle(dto.getDetalle());

	        return convertToDTO(formaPagoRepository.save(entity));
	    }

	    public FormaPagoDTO updateFormaPagoDTO(Integer id, FormaPagoDTO dto) {
	        Optional<FormaPago> existing = formaPagoRepository.findById(id);
	        if (!existing.isPresent()) return null;

	        FormaPago entity = existing.get();
	        entity.setFormaPago(dto.getFormaPago());
	        entity.setDetalle(dto.getDetalle());

	        return convertToDTO(formaPagoRepository.save(entity));
	    }

	    public void deleteFormaPago(Integer id) {
	        formaPagoRepository.deleteById(id);
	    }

	    public FormaPagoDTO convertToDTO(FormaPago entity) {
	        FormaPagoDTO dto = new FormaPagoDTO();
	        dto.setId(entity.getId());
	        dto.setFormaPago(entity.getFormaPago());
	        dto.setDetalle(entity.getDetalle());
	        return dto;
	    }

}
