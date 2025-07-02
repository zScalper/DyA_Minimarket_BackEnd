package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer>{

}
