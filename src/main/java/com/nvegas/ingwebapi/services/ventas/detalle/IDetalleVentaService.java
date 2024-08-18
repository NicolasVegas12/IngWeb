package com.nvegas.ingwebapi.services.ventas.detalle;

import com.nvegas.ingwebapi.models.entities.DetalleVentaEntity;


public interface IDetalleVentaService {
    DetalleVentaEntity getDetail(Integer id);
    DetalleVentaEntity saveOrUpdate(DetalleVentaEntity request);
    Boolean delete(Integer id);
}
