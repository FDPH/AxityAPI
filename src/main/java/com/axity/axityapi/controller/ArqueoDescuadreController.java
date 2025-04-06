package com.axity.axityapi.controller;

import com.axity.axityapi.exeption.GeneralException;
import com.axity.axityapi.model.entity.ArqueoDescuadre;
import com.axity.axityapi.service.ArqueoDescuadreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/arqueos")
public class ArqueoDescuadreController {
    private final ArqueoDescuadreService arqueoDescuadreService;

    public ArqueoDescuadreController(ArqueoDescuadreService arqueoDescuadreService) {
        this.arqueoDescuadreService = arqueoDescuadreService;
    }

    @GetMapping("/descuadres")
    public ResponseEntity<List<ArqueoDescuadre>> consultarDescuadres(
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) Integer mes,
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long productoId) {
        List<ArqueoDescuadre> lista = arqueoDescuadreService.filtrarDescuadres(anio, mes, sucursalId, productoId);

        if (lista.isEmpty()) {
            throw new GeneralException(URI.create("/api/arqueos/descuadres"),
                    "No se encontraron arqueos descuadres con los parámetros proporcionados.",
            HttpStatus.NOT_FOUND.value(),
                    LocalDate.now().toString(),
                    "No se encontraron arqueos descuadres con los parámetros proporcionados.");
        }

        return ResponseEntity.ok(lista);
    }
}
