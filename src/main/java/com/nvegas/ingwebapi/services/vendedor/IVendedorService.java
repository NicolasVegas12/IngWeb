package com.nvegas.ingwebapi.services.vendedor;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;

import java.util.List;

public interface IVendedorService {
    List<VendedorEntity> getList();
    VendedorEntity getDetail(Integer id);
    VendedorEntity saveOrUpdate(VendedorEntity request);
    Boolean delete(Integer id);
}
