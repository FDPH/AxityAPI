package com.axity.axityapi.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalProductoDocumentoId implements Serializable {
    private Long sucursalId;
    private Long productoId;
    private Long documentoId;
}
