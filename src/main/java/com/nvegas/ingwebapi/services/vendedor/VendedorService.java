package com.nvegas.ingwebapi.services.vendedor;

import com.nvegas.ingwebapi.models.entities.ProveedorEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;
import com.nvegas.ingwebapi.repository.IProveedorRepository;
import com.nvegas.ingwebapi.repository.IVendedorRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class VendedorService implements IVendedorService {

    @Autowired
    IVendedorRepository repository;

    @Override
    public List<VendedorEntity> getList() {
        return repository.findAll();
    }

    @Override
    @Nullable
    public VendedorEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public VendedorEntity saveOrUpdate(VendedorEntity request) {
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
