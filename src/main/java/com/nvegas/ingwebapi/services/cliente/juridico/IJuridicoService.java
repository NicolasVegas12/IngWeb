package com.nvegas.ingwebapi.services.cliente.juridico;

import com.nvegas.ingwebapi.models.entities.JuridicoEntity;

public interface IJuridicoService {
    JuridicoEntity getDetail(Integer id);

    JuridicoEntity saveOrUpdate(JuridicoEntity request);

    Boolean delete(Integer id);
}
