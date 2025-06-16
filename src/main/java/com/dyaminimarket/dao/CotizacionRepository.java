package com.dyaminimarket.dao;

import com.dyaminimarket.models.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion,Integer> {

}
