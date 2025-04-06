package com.axity.axityapi.repository;

import com.axity.axityapi.model.entity.SucursalProductoDocumento;
import com.axity.axityapi.model.entity.SucursalProductoDocumentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalProductoDocumentoRepository extends JpaRepository<SucursalProductoDocumento, SucursalProductoDocumentoId> {
}
