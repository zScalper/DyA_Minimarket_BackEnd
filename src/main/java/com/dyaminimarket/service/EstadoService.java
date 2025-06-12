package com.dyaminimarket.service;

import com.dyaminimarket.dao.EstadoRepository;
import com.dyaminimarket.models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> getEstados() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> getEstadoById(Integer id) {
        return estadoRepository.findById(id);
    }

    public Estado saveEstado(Estado estado) {
        return estadoRepository.save(estado);
    }
}
