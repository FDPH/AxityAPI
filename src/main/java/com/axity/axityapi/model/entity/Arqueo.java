package com.axity.axityapi.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "arqueos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Arqueo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarqueos")
    private Long idArqueo;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "diferencia", precision = 15, scale = 2)
    private BigDecimal diferencia;

    @Column(name = "saldo_final", precision = 15, scale = 2)
    private BigDecimal saldoFinal;

    @Enumerated(EnumType.STRING)
    @Column(name = "resultado", length = 1)
    private ResultadoArqueo resultado;

    @ManyToOne
    @JoinColumn(name = "sucursales_idsucursal", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "productos_idproducto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "documentos_iddocumento", nullable = false)
    private Documento documento;

}
