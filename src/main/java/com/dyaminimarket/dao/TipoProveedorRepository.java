package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.TipoProveedor;

@Repository
public interface TipoProveedorRepository extends JpaRepository<TipoProveedor, Integer> {

}
