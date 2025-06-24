package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.Despacho;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Integer> {

}
