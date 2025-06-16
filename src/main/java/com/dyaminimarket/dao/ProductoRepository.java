package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	
}
