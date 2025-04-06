package com.axity.axityapi;

import com.axity.axityapi.model.entity.Documento;
import com.axity.axityapi.model.entity.Producto;
import com.axity.axityapi.model.entity.Sucursal;
import com.axity.axityapi.repository.ArqueoDescuadreRepository;
import com.axity.axityapi.repository.ArqueoRepository;
import com.axity.axityapi.service.ArqueoBatchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

public class ArqueoBatchServiceTest {
    @Mock
    private ArqueoRepository arqueoRepository;

    @Mock
    private ArqueoDescuadreRepository arqueoDescuadreRepository;

    @InjectMocks
    private ArqueoBatchService arqueoBatchService;

    @Test
    public void testGuardaSoloArqueosNuevosConResultadoD() {
        // Datos de prueba
        LocalDate fecha = LocalDate.of(2025, 1, 1);
        Sucursal sucursal = new Sucursal(1L, "00101", "Sucursal A");
        Producto producto = new Producto(1L, "PR01", "Producto 1");
        Documento documento = new Documento(1L, "DOC001", "Documento 1");


    }
}
