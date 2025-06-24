package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
