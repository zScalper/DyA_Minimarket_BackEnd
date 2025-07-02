package com.dyaminimarket.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.Unidad;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {

}
