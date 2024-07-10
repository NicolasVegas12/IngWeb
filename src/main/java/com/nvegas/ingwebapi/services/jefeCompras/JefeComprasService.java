package com.nvegas.ingwebapi.services.jefeCompras;

import com.nvegas.ingwebapi.models.entities.JefeComprasEntity;
import com.nvegas.ingwebapi.models.entities.VendedorEntity;
import com.nvegas.ingwebapi.repository.IJefeComprasRepository;
import com.nvegas.ingwebapi.repository.IVendedorRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class JefeComprasService implements  IJefeComprasService {
    @Autowired
    IJefeComprasRepository repository;

    @Override
    public List<JefeComprasEntity> getList() {
        return repository.findAll();
    }

    @Override
    @Nullable
    public JefeComprasEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public JefeComprasEntity saveOrUpdate(JefeComprasEntity request) {
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
