package com.axity.axityapi.service;

import com.axity.axityapi.exeption.GeneralException;
import com.axity.axityapi.model.entity.Arqueo;
import com.axity.axityapi.model.entity.ArqueoDescuadre;
import com.axity.axityapi.model.entity.ResultadoArqueo;
import com.axity.axityapi.repository.ArqueoDescuadreRepository;
import com.axity.axityapi.repository.ArqueoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Service
public class ArqueoBatchService {
    private final ArqueoRepository arqueoRepository;
    private final ArqueoDescuadreRepository arqueoDescuadreRepository;

    public ArqueoBatchService(ArqueoRepository arqueoRepository, ArqueoDescuadreRepository arqueoDescuadreRepository) {
        this.arqueoRepository = arqueoRepository;
        this.arqueoDescuadreRepository = arqueoDescuadreRepository;
    }

    @Transactional
    public void ejecutarProcesoBatch(int anio, int mes) {

        //Lanzar excepcion si anno o mes son incorrectos
        validateDate(anio, mes);

        //Traer los arqueos por rando de fecha de inicio a fin de ese mes
        List<Arqueo> arqueos = arqueoRepository.findByFechaBetween(
                LocalDate.of(anio, mes, 1),
                LocalDate.of(anio, mes, 1).plusMonths(1).minusDays(1)
        );

        //Filtrar por los aqueos que sean de tipo D
        //ARESAX Si la letra es D y las fechas concuerdan se debe ir a descuadros
        List<Arqueo> descuadrados = arqueos.stream()
                .filter(a -> a.getResultado() == ResultadoArqueo.D)
                .toList();

        descuadrados.forEach(arqueo -> {
            // Validar si cada dato existe en base de datos y si no existe guardarlo
            boolean existeDescuadre = arqueoDescuadreRepository.existsByAnioAndMesAndSucursalAndProductoAndDocumento(
                    anio,
                    mes,
                    arqueo.getSucursal(),
                    arqueo.getProducto(),
                    arqueo.getDocumento()
            );

            // Se guarda el registro si no existe ya en base de datos
            if (!existeDescuadre) {
                ArqueoDescuadre descuadre = new ArqueoDescuadre();
                descuadre.setAnio(anio);
                descuadre.setMes(mes);
                descuadre.setDiferencia(arqueo.getDiferencia());
                descuadre.setSucursal(arqueo.getSucursal());
                descuadre.setProducto(arqueo.getProducto());
                descuadre.setDocumento(arqueo.getDocumento());
                arqueoDescuadreRepository.save(descuadre);
            }
        });
    }

    private void validateDate(int anio, int mes) {
        if (isDateIncorrect(anio, mes)) {
            throw new GeneralException(URI.create(""),
                    "El año y el mes no pueden estar vacíos",
                    HttpStatus.BAD_REQUEST.value(),
                    LocalDate.now().toString(),
                    "Introduce un año y un mes válidos");
        }
    }

    public boolean isDateIncorrect(int anio, int mes) {
        return anio == 0 || mes > 12 || mes == 0;
    }

}
