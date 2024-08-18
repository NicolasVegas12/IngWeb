package com.nvegas.ingwebapi.services.cliente;

import com.nvegas.ingwebapi.models.entities.ClienteEntity;
import com.nvegas.ingwebapi.models.entities.VentaEntity;
import com.nvegas.ingwebapi.repository.IClienteRepository;
import com.nvegas.ingwebapi.repository.IVentaRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClienteService implements IClienteService {


    @Autowired
    IClienteRepository repository;

    @Override
    public List<ClienteEntity> getList() {
        return repository.findAll();
    }

    @Override
    @Nullable
    public ClienteEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ClienteEntity saveOrUpdate(ClienteEntity request) {
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
