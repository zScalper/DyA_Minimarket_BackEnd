package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {


}
