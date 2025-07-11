package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.DetalleRequerimiento;

@Repository
public interface DetalleRequerimientoRepository extends JpaRepository<DetalleRequerimiento, Integer> {

}
