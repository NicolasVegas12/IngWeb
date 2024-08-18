package com.nvegas.ingwebapi.services.ventas.detalle;

import com.nvegas.ingwebapi.models.entities.DetalleVentaEntity;
import com.nvegas.ingwebapi.repository.IDetalleVentaRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DetalleVentaService implements IDetalleVentaService {
    @Autowired
    IDetalleVentaRepository repository;


    @Override
    @Nullable
    public DetalleVentaEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DetalleVentaEntity saveOrUpdate(DetalleVentaEntity request) {
        return repository.save(request);
    }

    @Override
    public Boolean delete(Integer id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
