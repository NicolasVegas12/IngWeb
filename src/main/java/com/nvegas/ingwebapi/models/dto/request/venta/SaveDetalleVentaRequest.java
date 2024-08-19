package com.nvegas.ingwebapi.models.dto.request.venta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDetalleVentaRequest {
    private int idProducto;
    private int cantidad;



}
