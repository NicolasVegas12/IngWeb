package com.nvegas.ingwebapi.services.usuario;

import com.nvegas.ingwebapi.models.entities.UsuariosEntity;
import com.nvegas.ingwebapi.repository.IUsuarioRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUsuarioRepository repository;

    @Override
    public List<UsuariosEntity> getList() {
        return repository.findAll();
    }

    @Override
    @Nullable
    public UsuariosEntity getDetail(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UsuariosEntity saveOrUpdate(UsuariosEntity request) {
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

    @Override
    @Nullable
    public UsuariosEntity login(String mail, String password) {
        return repository.getUsuariosEntitiesByCorreoAndContrasena(mail, password);
    }


}
