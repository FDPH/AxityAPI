package com.axity.axityapi.repository;

import com.axity.axityapi.model.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    Documento findByCodigoDocumento(String codigoDocumento);
}
