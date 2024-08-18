package com.nvegas.ingwebapi.services.ventas;

import com.nvegas.ingwebapi.models.entities.VentaEntity;
import com.nvegas.ingwebapi.repository.IVentaRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VentaService implements IVentaService {

    @Autowired
    IVentaRepository repository;

    @Override
    public List<VentaEntity> getList() {
        return repository.findAll();
    }

    @Override
    @Nullable
    public VentaEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VentaEntity saveOrUpdate(VentaEntity request) {
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
