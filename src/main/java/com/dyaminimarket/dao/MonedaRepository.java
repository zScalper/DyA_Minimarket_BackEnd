package com.dyaminimarket.dao;

import com.dyaminimarket.models.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Integer> {

}
