package com.nvegas.ingwebapi.services.jefeCompras;

import com.nvegas.ingwebapi.models.entities.JefeComprasEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;

import java.util.List;

public interface IJefeComprasService {
    List<JefeComprasEntity> getList();
    JefeComprasEntity getDetail(Integer id);
    JefeComprasEntity saveOrUpdate(JefeComprasEntity request);
    Boolean delete(Integer id);
}
