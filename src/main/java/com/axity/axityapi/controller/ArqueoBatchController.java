package com.axity.axityapi.controller;

import com.axity.axityapi.model.request.ArqueoBatchRequestBody;
import com.axity.axityapi.service.ArqueoBatchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/batch")
public class ArqueoBatchController {
    private final ArqueoBatchService arqueoBatchService;

    public ArqueoBatchController(ArqueoBatchService arqueoBatchService) {
        this.arqueoBatchService = arqueoBatchService;
    }

    @PostMapping("/procesar")
    public ResponseEntity<String> ejecutarProcesoBatch(@Valid @RequestBody ArqueoBatchRequestBody request) {
        arqueoBatchService.ejecutarProcesoBatch(request.getAnno(), request.getMes());
        return ResponseEntity.ok("Proceso batch ejecutado correctamente.");
    }
}
