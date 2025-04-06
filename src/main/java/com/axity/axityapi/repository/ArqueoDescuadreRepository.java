package com.axity.axityapi.repository;

import com.axity.axityapi.model.entity.ArqueoDescuadre;
import com.axity.axityapi.model.entity.Documento;
import com.axity.axityapi.model.entity.Producto;
import com.axity.axityapi.model.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArqueoDescuadreRepository extends JpaRepository<ArqueoDescuadre, Long> {
    @Query("SELECT a FROM ArqueoDescuadre a WHERE " +
            "(:anio IS NULL OR a.anio = :anio) AND " +
            "(:mes IS NULL OR a.mes = :mes) AND " +
            "(:sucursalId IS NULL OR a.sucursal.id = :sucursalId) AND " +
            "(:productoId IS NULL OR a.producto.id = :productoId)")
    List<ArqueoDescuadre> findByFilters(@Param("anio") Integer anio, @Param("mes") Integer mes,
                                        @Param("sucursalId") Long sucursalId,
                                        @Param("productoId") Long productoId);

    boolean existsByAnioAndMesAndSucursalAndProductoAndDocumento(int anio, int mes, Sucursal sucursal,
                                                                 Producto producto, Documento documento);
}
