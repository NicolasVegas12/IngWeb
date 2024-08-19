package com.nvegas.ingwebapi.models.dto.response.venta;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class GetVentaResponse {

    private int idVenta;

    private String nroVenta;

    private Date fecha;

    private Boolean estado;

    private int idCdp;


    private int idCliente;
    private int idVendedor;
    private Collection<GetDetalleVentaResponse> detalleVenta;


}
