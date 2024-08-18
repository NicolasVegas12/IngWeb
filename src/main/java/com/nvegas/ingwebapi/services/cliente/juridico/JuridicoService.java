package com.nvegas.ingwebapi.services.cliente.juridico;

import com.nvegas.ingwebapi.models.entities.JuridicoEntity;
import com.nvegas.ingwebapi.repository.IJuridicoRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JuridicoService implements IJuridicoService {

    @Autowired
    IJuridicoRepository repository;


    @Override
    @Nullable
    public JuridicoEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public JuridicoEntity saveOrUpdate(JuridicoEntity request) {
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
