package com.nvegas.ingwebapi.models.dto.request.venta;

import com.nvegas.ingwebapi.models.entities.VentaEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Getter
@Setter
public class SaveVentaRequest {
    private String nroVenta;
    private Date fecha;
    private int idCliente;
    private int idVendedor;
    private Collection<SaveDetalleVentaRequest> detalleVenta;

    public VentaEntity toEntity(){
        VentaEntity entity = new VentaEntity();
        entity.setNroVenta(this.getNroVenta());
        entity.setFecha(this.getFecha());
        entity.setEstado(true);
        entity.setDetalleVentasByIdVenta(Collections.emptyList());
        return entity;
    }
}
