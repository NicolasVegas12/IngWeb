package com.nvegas.ingwebapi.services.proveedor;

import com.nvegas.ingwebapi.models.entities.ProductoEntity;
import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.repository.IProductRepository;
import com.nvegas.ingwebapi.repository.IProveedorRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProveedorService implements IProveedorService {
    @Autowired
    IProveedorRepository repository;

    @Override
    public List<ProveedorEntity> getList() {
        return repository.findAll();
    }

    @Override
    @Nullable
    public ProveedorEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProveedorEntity saveOrUpdate(ProveedorEntity request) {
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
