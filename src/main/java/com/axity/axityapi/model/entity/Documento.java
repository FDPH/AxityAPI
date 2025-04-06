package com.axity.axityapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddocumento")
    private Long idDocumento;

    @Column(name = "codigo_documento", unique = true, length = 6)
    private String codigoDocumento;

    @Column(name = "descripcion", length = 50)
    private String descripcion;
}
