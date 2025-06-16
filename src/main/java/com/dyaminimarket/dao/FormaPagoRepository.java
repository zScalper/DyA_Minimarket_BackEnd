package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dyaminimarket.models.FormaPago;

@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago,Integer>{

}
