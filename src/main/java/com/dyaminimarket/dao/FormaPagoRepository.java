package com.dyaminimarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dyaminimarket.models.FormaPago;


import org.springframework.stereotype.Repository;


@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago,Integer>{

}
