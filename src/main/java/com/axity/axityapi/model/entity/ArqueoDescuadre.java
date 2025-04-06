package com.axity.axityapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "arqueos_descuadres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArqueoDescuadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarqueos_descuadres")
    private Long idArqueoDescuadre;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "diferencia", precision = 15, scale = 2)
    private BigDecimal diferencia;

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
