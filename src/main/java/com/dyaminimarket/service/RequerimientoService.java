package com.dyaminimarket.service;

import com.dyaminimarket.dao.RequerimientoRepository;
import com.dyaminimarket.dto.RequerimientoDTO;
import com.dyaminimarket.models.Estado;
import com.dyaminimarket.models.Requerimiento;
import com.dyaminimarket.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequerimientoService {

    @Autowired
    private RequerimientoRepository requerimientoRepository;



  public List<Requerimiento> getRequerimientos(){
      return requerimientoRepository.findAll();
  }

  public Optional<Requerimiento> getRequerimientoById(Integer id){
   return  requerimientoRepository.findById(id);
  }


  public Requerimiento saveRequerimiento(Requerimiento requerimiento){
      return requerimientoRepository.save(requerimiento);
  }

  public void deleteRequerimientoById(Integer id){
      requerimientoRepository.deleteById(id);
  }

 // Conversion a DTO
  /*
  public RequerimientoDTO convertToDTO(Requerimiento requerimiento){
    RequerimientoDTO dto = new RequerimientoDTO();
    dto.setFecha(requerimiento.getFecha());
    dto.setCodDetalleRequerimiento(requerimiento.getCodDetalleRequerimiento());
    dto.setCodCotizacion(requerimiento.getCodCotizacion());
      dto.setCodEstado(requerimiento.getCodEstado() != null ? requerimiento.getCodEstado().getId() : null);
      dto.setCodUsuario(requerimiento.getCodUsuario() != null ? requerimiento.getCodUsuario().getId() : null);
      return dto;
  }*/



}
