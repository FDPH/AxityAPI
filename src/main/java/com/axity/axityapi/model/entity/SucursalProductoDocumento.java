package com.axity.axityapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sucursal_producto_documento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalProductoDocumento {
    @EmbeddedId
    private SucursalProductoDocumentoId id;

    @ManyToOne
    @MapsId("sucursalId")
    @JoinColumn(name = "sucursales_idsucursal")
    private Sucursal sucursal;

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "productos_idproducto")
    private Producto producto;

    @ManyToOne
    @MapsId("documentoId")
    @JoinColumn(name = "documentos_iddocumento")
    private Documento documento;
}
