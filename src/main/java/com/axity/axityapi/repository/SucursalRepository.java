package com.axity.axityapi.repository;

import com.axity.axityapi.model.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    Sucursal findByCodigoSucursal(String codigoSucursal);
}
