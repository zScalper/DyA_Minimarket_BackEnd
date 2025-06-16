package com.dyaminimarket.service;

import com.dyaminimarket.dao.MonedaRepository;
import com.dyaminimarket.dto.MonedaDTO;
import com.dyaminimarket.models.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    // Obtenemos todas las monedas
    public List<MonedaDTO> getMonedasDTO() {
        return monedaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    // Obtenemos una moneda por ID
    public Optional<MonedaDTO> getMonedaById(Integer id) {
        return monedaRepository.findById(id).map(this::convertToDTO);
    }



    public MonedaDTO saveMonedaDTO(MonedaDTO monedaDTO) {
        Moneda moneda = new Moneda();
        moneda.setId(monedaDTO.getId());
        moneda.setNombre(monedaDTO.getNombre());
        moneda.setDetalle(monedaDTO.getDetalle());

        Moneda savedMoneda = monedaRepository.save(moneda);
        return convertToDTO(savedMoneda);
    }


    public MonedaDTO updateMonedaDTO(Integer id, MonedaDTO monedaDTO) {
        Optional<Moneda> existingMoneda = monedaRepository.findById(id);
        if (!existingMoneda.isPresent()) {
            return null;  // Opcionalmente, podrías lanzar una excepción
        }

        Moneda moneda = existingMoneda.get();
        moneda.setNombre(monedaDTO.getNombre());
        moneda.setDetalle(monedaDTO.getDetalle());

        Moneda updatedMoneda = monedaRepository.save(moneda);
        return convertToDTO(updatedMoneda);
    }



    // Eliminar una moneda por ID
    public void deleteMoneda(Integer id) {
        monedaRepository.deleteById(id);
    }

    public MonedaDTO convertToDTO(Moneda moneda) {
        MonedaDTO dto = new MonedaDTO();
        dto.setId(moneda.getId());
        dto.setNombre(moneda.getNombre());
        dto.setDetalle(moneda.getDetalle());
        return dto;
    }


}
