package com.nvegas.ingwebapi.services.cliente.natural;

import com.nvegas.ingwebapi.models.entities.JuridicoEntity;
import com.nvegas.ingwebapi.models.entities.NaturalEntity;
import com.nvegas.ingwebapi.repository.IJuridicoRepository;
import com.nvegas.ingwebapi.repository.INaturalRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NaturalService implements INaturalService {

    @Autowired
    INaturalRepository repository;


    @Override
    @Nullable
    public NaturalEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public NaturalEntity saveOrUpdate(NaturalEntity request) {
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
