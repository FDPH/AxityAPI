package com.axity.axityapi.service;

import com.axity.axityapi.model.entity.ArqueoDescuadre;
import com.axity.axityapi.repository.ArqueoDescuadreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArqueoDescuadreService {
    private final ArqueoDescuadreRepository arqueoDescuadreRepository;

    public ArqueoDescuadreService(ArqueoDescuadreRepository arqueoDescuadreRepository) {
        this.arqueoDescuadreRepository = arqueoDescuadreRepository;
    }

    public List<ArqueoDescuadre> filtrarDescuadres(Integer anio, Integer mes, Long sucursalId, Long productoId) {
        return arqueoDescuadreRepository.findByFilters(anio, mes, sucursalId, productoId);
    }
}
