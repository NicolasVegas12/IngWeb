package com.nvegas.ingwebapi.services.cliente.natural;

import com.nvegas.ingwebapi.models.entities.JuridicoEntity;
import com.nvegas.ingwebapi.models.entities.NaturalEntity;

public interface INaturalService {
    NaturalEntity getDetail(Integer id);

    NaturalEntity saveOrUpdate(NaturalEntity request);

    Boolean delete(Integer id);
}
