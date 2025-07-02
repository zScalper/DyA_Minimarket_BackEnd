package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.DetalleDespacho;

@Repository
public interface DetalleDespachoRepository extends JpaRepository<DetalleDespacho, Integer>{

}
