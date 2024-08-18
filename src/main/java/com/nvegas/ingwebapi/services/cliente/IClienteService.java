package com.nvegas.ingwebapi.services.cliente;

import com.nvegas.ingwebapi.models.entities.ClienteEntity;
import com.nvegas.ingwebapi.models.entities.VentaEntity;

import java.util.List;

public interface IClienteService {

    List<ClienteEntity> getList();
    ClienteEntity getDetail(Integer id);
    ClienteEntity saveOrUpdate(ClienteEntity request);
    Boolean delete(Integer id);
}
