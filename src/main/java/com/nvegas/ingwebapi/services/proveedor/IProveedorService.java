package com.nvegas.ingwebapi.services.proveedor;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;

import java.util.List;

public interface IProveedorService {
    List<ProveedorEntity> getList();
    ProveedorEntity getDetail(Integer id);
    ProveedorEntity saveOrUpdate(ProveedorEntity request);
    Boolean delete(Integer id);
}
