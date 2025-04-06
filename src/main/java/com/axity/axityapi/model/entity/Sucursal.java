package com.axity.axityapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sucursales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsucursal")
    private Long idSucursal;

    @Column(name = "codigo_sucursal", unique = true, length = 5)
    private String codigoSucursal;

    @Column(name = "nombre", length = 50)
    private String nombre;
}
