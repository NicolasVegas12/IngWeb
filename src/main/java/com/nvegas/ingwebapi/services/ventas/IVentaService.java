package com.nvegas.ingwebapi.services.ventas;

import com.nvegas.ingwebapi.models.entities.VentaEntity;

import java.util.List;

public interface IVentaService {

    List<VentaEntity> getList();

    VentaEntity getDetail(Integer id);

    VentaEntity saveOrUpdate(VentaEntity request);

    Boolean delete(Integer id);
}
