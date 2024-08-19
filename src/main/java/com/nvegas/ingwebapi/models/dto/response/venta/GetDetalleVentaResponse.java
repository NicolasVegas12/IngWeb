package com.nvegas.ingwebapi.models.dto.response.venta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDetalleVentaResponse {


    private int idProducto;
    private String producto;
    private double montoUnitario;
    private int cantidad;
    private double monto;


}
